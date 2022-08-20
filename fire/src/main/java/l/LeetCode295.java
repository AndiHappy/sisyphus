package l;

import java.util.*;

public class LeetCode295 {


    public boolean wordPattern(String pattern, String str) {
        HashMap<Character , String > map = new HashMap();
        String[] temp = str.split("\\s");
        char[] c = pattern.toCharArray();
        if(temp.length != c.length)
            return false;

        for(int i = 0 ; i<temp.length ; i++){
            if(!map.containsKey(c[i])){
                if(map.containsValue(temp[i]))
                    return false;
                map.put(c[i] , temp[i]);
            }else{
                if(!map.get(c[i]).equals(temp[i]))
                    return false;
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        // pattern to String
        Map<Character, String> dict = new HashMap();
        Set<String> set = new HashSet();

        for (int i = 0; i < words.length; ++i) {

            char c = pattern.charAt(i);
            // pattern first char c
            if (!dict.containsKey(c)) {
                // add return true if this set did not already contain the specified
                if (!set.add(words[i])) {
                    return false;
                }
                dict.put(c, words[i]);
            } else if (!dict.get(c).equals(words[i])) {
                return false;
            }
        }

        return true;
    }


    public static boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;

        Map index = new HashMap();

        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    /**
     *
     *
     * */
    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        MedianFinder test = new MedianFinder();
        test.addNum(1);
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());

    }



    static class MedianFinder {

        //最大堆和最小堆对应的数据结构就是Pro
        public PriorityQueue<Integer> min = null;
        public PriorityQueue<Integer> max = null;
        /** initialize your data structure here. */
        public MedianFinder() {
            min=new PriorityQueue<Integer>();
            max=new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        }

        public void addNum(int num) {
            max.offer(num);
            min.offer(max.poll());
            if (max.size() < min.size()){
                max.offer(min.poll());
            }
        }

        /**
         * 首先是理解中位数的概念：中位数
         *        如果是偶数: 1，2，3，4 那就是 (a[n/2] + a[n/2+1]) /2
         *        如果是奇数：1，2，3 那就是 a[(n+1)/2] 的值
         * 这样话，我们首先要对输入的值进行排序，然后需要把队列拆成两节，分别记录这两节的最大值和最小值
         * */
        // Returns the median of current data stream
        public double findMedian() {
            if (max.size() == min.size()) return (max.peek() + min.peek()) /2.0;
            else return max.peek();
        }
    }

   static class MedianFinder3 {
        private Queue<Long> left = new PriorityQueue(), right = new PriorityQueue();
        public void addNum(int num) {
            left.add((long) num);
            right.add(-left.poll());
            if (left.size() < right.size())
                left.add(-right.poll());
        }
        public double findMedian() {
            return left.size() > right.size()
                    ? left.peek()
                    : (left.peek() - right.peek()) / 2.0;
        }
    };

    static class MedianFinder2 {
        List<Integer> list = new ArrayList<>();
        /** initialize your data structure here. */
        public MedianFinder2() {
        }

        // 插入number 在合适的位置，二分查找法，插入的值为num
        // 要求： a[i] > num > a[i-1]
        // a[mid] < num  则： low = mid+1
        // a[mid] > num  &&  a[mid-1] > num 则： high = mid-1
        public void addNum(int num) {
            int insert = -1;
            int low = 0;
            int high = list.size() - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (num <= list.get(mid)) {
                    //判断 num 是否大于等于前边的数
                    int pre = mid > 0 ? list.get(mid - 1) : Integer.MIN_VALUE;
                    if (num >= pre) {
                        insert = mid;
                        break;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    low = mid + 1;
                }
            }
            if (insert == -1) {
                insert = list.size();
            }
            // 将当前数插入
            list.add(insert, num);
        }

        public double findMedian() {
            int n = list.size();
            if ((n & 1) == 1) {
                return list.get(n / 2);
            } else {
                return ((double) list.get(n / 2) + list.get(n / 2 - 1)) / 2;
            }
        }
    }

    static class MedianFinder1 {
        List<Integer> list = new ArrayList<>();
        /** initialize your data structure here. */
        public MedianFinder1() {
        }
        public void addNum(int num) {
            list.add(num);
        }
        public double findMedian() {
            Collections.sort(list);
            int n = list.size();
            if ((n & 1) == 1) {
                return list.get(n / 2);
            } else {
                return ((double) list.get(n / 2) + list.get(n / 2 - 1)) / 2;
            }
        }
    }
}
