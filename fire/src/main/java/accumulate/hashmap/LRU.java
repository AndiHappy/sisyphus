package accumulate.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    /*
    *
    请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。

实现 LRUCache 类：

LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以O(1) 的平均时间复杂度运行。
    *
    * */

    interface ILRU{
        /*
        * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
        * O(1)
         * */
        int get(int key);

        /*
        * 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
        * 如果插入操作导致关键字数量超量，则应该 逐出 最久未使用的关键字。
        * */
        void put(int key,int value);
    }

    /**
     * get，put的O(1),这个可以采用hashMap的方式
     * 但是如果超量以后，删除最久未使用的关键字，就需要另外的一个数据结构，来保存关键字的使用的日期，或者表示关键字最近是否使用了
     * 我们采取的双端链表的方式来表示，最新被使用的放在链表的尾部，那么最久没有被使用的就是在头部
     * */

    //双端链表的节点数据
    class Node{
        private int key;
        private int val;
        private Node next;
        private Node pre;
        public Node(int k,int v){
            this.key=k;
            this.val=v;
        }
    }

    class DoubleLinkedList{
        private Node head = new Node(0,0);
        private Node tail = new Node(0,0);
        private int size;

        //构造函数
        public DoubleLinkedList(){
            head.next=tail;
            tail.pre=head;
            size=0;
        }

        //添加到队尾节点
        public void addLast(Node x){
            x.pre = tail.pre;
            tail.pre.next=x;
            x.next = tail;
            tail.pre=x;
            size++;
        }

        // 删除指定的节点
        public void delete(Node x){
            x.next.pre = x.pre.next;
            x.pre.pre.next = x.next;
            size--;
        }

        // 删除并返回头结点
        public Node removeHead(){
            if(head.next == tail) return null;
            Node realHead = head.next;
            delete(realHead);
            return realHead;
        }

        //获取链表的长度
        public int getSize(){
            return size;
        }
    }

    private Map<Integer, Node> map;
    private DoubleLinkedList doubleLinkedList;
    private int cap;

    //构造函数
    public LRU(int capatity){
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList();
        this.cap=capatity;
    }

    //获取数据
    public int get(int key){
        if(map.containsKey(key)){
            //先将key标记为最近使用过
            markRecentUsed(key);
            return map.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int k,int v){
        if(map.containsKey(k)){
            deleteKey(k);
            addRecent(k,v);
            return;
        }
        int size = doubleLinkedList.getSize();
        if(size >= cap){
            removeLeastRecently();
        }
        addRecent(k,v);
    }

    private void removeLeastRecently() {
        Node old = doubleLinkedList.removeHead();
        int oldkey = old.key;
        map.remove(oldkey);
    }

    private void addRecent(int k, int v) {
        Node x = new Node(k,v);
        doubleLinkedList.addLast(x);
        map.put(k,x);
    }

    private void deleteKey(int k) {
    }

    private void markRecentUsed(int key) {
        Node x = map.get(key);
        doubleLinkedList.delete(x); // 先从双链表删除
        doubleLinkedList.addLast(x); // 再添加到链表末尾， 因为尾部是最近使用过的元素
    }


}
