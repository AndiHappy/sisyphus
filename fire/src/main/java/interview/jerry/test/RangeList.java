package interview.jerry.test;


import java.util.*;

public class RangeList {

    public TreeMap<Integer, Range> store = new TreeMap<Integer, Range>();

    static class Range {
        private int from;
        private int to;

        public Range(int from, int to) {
            if(to < from) throw new RuntimeException(" to must bigger than from !");
            this.from = from;
            this.to = to;
        }
    }

    /**
     * Adds a range to the list
     *
     * @param {Array<number>} range - Array of two integers that specify beginning and end of range.
     */
    public void add(Range range) {
        if (range == null) return;
        // 特殊情况
        if (store.isEmpty()) {
            justAddRange(range);
        } else {
            SortedSet<Integer> fromTailSet = store.navigableKeySet().tailSet(range.from);
            if (fromTailSet.isEmpty()) {
                justAddRange(range);
            } else {
                //[1,6] [10,21]  [28 50]
                Integer tailFirstValue = fromTailSet.first();
                Range tailFirst = store.get(tailFirstValue);

//                fromTailSet不为null，说明插入rang的from在链表中，有大于它的点存在
//                第一个大于它的点，是一个开始节点
                if (tailFirst.from == tailFirstValue) {
                    //如果是开始的端点，如果插入节点小于开始节点，则需要覆盖前一个节点，或者生成新的节点
                    //如果是第一种情况，插入节点的to值小于第一个大于开始节点的起始值，就是生成新的节点
                    if (range.to < tailFirst.from) {
                        justAddRange(range);
                    } else {
                        //如果是第二中情况，插入节点的to值大于第一个开始节点的起始值，则需要覆盖或者更新
                        store.remove(tailFirst.from);
                        tailFirst.from = range.from;
                        store.put(tailFirst.from, tailFirst);

                        if (range.to > tailFirst.to) {
                            //再来确定rang的to值，覆盖到那个位置
                            List<Integer> cache = new ArrayList<>();
                            //再来确定rang的to值，覆盖到那个位置
                            fromTailSet.stream().forEach(x -> {
                                if (x < range.to) cache.add(x);
                            });
                            cache.stream().forEach(x -> store.remove(x));
                            tailFirst.to = range.to;
                            store.put(tailFirst.to, tailFirst);
                        }
                    }
                }

                //如果是结束的端点，如果插入节点小于结束的节点，则需要更新当前节点或者直接覆盖
                if (tailFirst.to == tailFirstValue) {
                    if (range.to > tailFirst.to) {
                        List<Integer> cache = new ArrayList<>();
                        //再来确定rang的to值，覆盖到那个位置
                        fromTailSet.stream().forEach(x -> {
                            if (x < range.to) cache.add(x);
                        });
                        cache.stream().forEach(x -> store.remove(x));
                        tailFirst.to = range.to;
                        store.put(tailFirst.to, tailFirst);
                    }
                }
            }
        }
    }

    private void justAddRange(Range range) {
        store.put(range.from, range);
        store.put(range.to, range);
    }

    /**
     * Removes a range from the list
     *
     * @param {Array<number>} range - Array of two integers that specify beginning and
     *                        end of range.
     */
    public void remove(Range range) {
        if (range == null || store.isEmpty()) return;
        SortedSet<Integer> fromTailSet = store.navigableKeySet().tailSet(range.from);
//      fromTailSet为null，删除节点的from开始于没有覆盖的地方
        //[1,6] [7,8] [10,21]
        if (!fromTailSet.isEmpty()) {
            Integer tailFirstValue = fromTailSet.first();
            Range tailFirst = store.get(tailFirstValue);
            //如果大于删除节点的是开始端点
            if (tailFirst.from == tailFirstValue) {
                //根据删除节点的to，分为三种情况
                if(range.to <= tailFirst.from) return;
                if(range.to < tailFirst.to){
                    store.remove(tailFirst.from);
                    Range newRange = new Range(range.to, tailFirst.to);
                    justAddRange(newRange);
                    return;
                } else if (range.to == tailFirst.to) {
                    store.remove(tailFirst.to);
                    store.remove(tailFirst.from);
                } else if (range.to > tailFirst.to) {
                    //[1,6] [7,8] [10,21]，[30,50] 需要删除的是：9，13
                    List<Integer> cache = new ArrayList<>();
                    //再来确定rang的to值，覆盖到那个位置
                    fromTailSet.stream().forEach(x -> { if (x < range.to) cache.add(x);});
                    for (int i = 0; i < cache.size(); i++) {
                        if (cache.get(i) < range.to) {
                            Range dele = store.get(cache.get(i));
                            if (dele.to > range.to) {
                                store.remove(dele.from);
                                dele.from = range.to;
                                store.put(dele.from, dele);
                                break;
                            }
                            store.remove(cache.get(i));
                        }
                    }
                    return;
                }
            }
            //如果是结束的端点，如果插入节点小于结束的节点，则需要更新当前节点或者直接覆盖
            if (tailFirst.to == tailFirstValue) {
                if (range.to < tailFirst.to) {
                    //一个节点劈成两个节点
                    Range newRange = new Range(range.to, tailFirst.to);
                    justAddRange(newRange);

                    tailFirst.to = range.from;
                    store.put(tailFirst.to, tailFirst);
                }else if (range.to == tailFirst.to) {
                    store.remove(tailFirst.to);
                    tailFirst.to = range.from;
                    store.put(tailFirst.to,tailFirst);
                }else if(range.to > tailFirst.to){
                    //一个节点劈成两个节点
                    store.remove(tailFirst.to);
                    tailFirst.to = range.from;
                    store.put(tailFirst.to,tailFirst);

                    //[1,3) [7,8) [11,15) [17,21) 需要删除的是：2,19
                    List<Integer> cache = new ArrayList<>();
                    //再来确定rang的to值，覆盖到那个位置
                    fromTailSet.stream().forEach(x -> {if (x < range.to && x> range.from) cache.add(x);});

                    for (int i = 0; i < cache.size(); i++) {
                        if (cache.get(i) < range.to) {
                            Range dele = store.get(cache.get(i));
                            if (dele != null && dele.to > range.to) {
                                store.remove(dele.from);
                                dele.from = range.to;
                                store.put(dele.from, dele);
                                break;
                            }else if(dele != null){
                                //因为是连带的删除，所以在第二次循环的时候，需要判断 dele 是否为null
                                store.remove(dele.from);
                                store.remove(dele.to);
                            }

                        }
                    }
                }
            }
        }

    }

    public String toString() {
        if (store.isEmpty()) {
            return "[)";
        }

        StringBuilder ringListString = new StringBuilder();
        int i = 0;
        Iterator<Integer> rangeFrom = store.navigableKeySet().iterator();
        while (rangeFrom.hasNext()) {
            Integer from = rangeFrom.next();
            if (i % 2 == 0) {
                if (i != 0) ringListString.append(" ");
                Range range = store.get(from);
                ringListString.append("[").append(range.from).append(",").append(range.to).append(")");
            }
            i++;
        }
        return ringListString.toString();

    }

    public static void main(String[] args) {


        RangeList rangeList = new RangeList();
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.add(new Range(1, 5));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.add(new Range(10, 20));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.add(new Range(20, 20));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.add(new Range(20, 21));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.add(new Range(2, 4));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.add(new Range(3, 6));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.add(new Range(7, 8));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.remove(new Range(10,10));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.remove(new Range(10,11));//[1,6) [7,8) [11,21)
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.remove(new Range(15, 17));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.remove(new Range(3, 6));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());

        rangeList.remove(new Range(2, 19));
        System.out.println(rangeList.toString());
        System.out.println(rangeList.store.size());
    }

}