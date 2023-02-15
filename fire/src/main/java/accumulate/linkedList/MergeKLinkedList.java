package accumulate.linkedList;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLinkedList {

    /*
    * 合并链表
    * 这个在leetCode已经写过几遍了，但是使用优先队列的，还没有熟练
    * */

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0) return null;
        //虚拟头节点
        ListNode head = new ListNode(0);
        ListNode tail =head;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, Comparator.comparingInt(a -> a.val));

        for (int i = 0; i < lists.length; i++) {
            queue.add(lists[i]);
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            tail.next=node;
            if(node.next != null){
                queue.add(node.next);
            }
            tail=tail.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next=new ListNode(3);
        head1.next.next=new ListNode(5);
        head1.next.next.next=new ListNode(7);

        ListNode head2 = new ListNode(6);
        head2.next=new ListNode(2);
        head2.next.next=new ListNode(4);
        head2.next.next.next=new ListNode(8);

        ListNode[] nodes = new ListNode[]{head1,head2};
        System.out.println(mergeKLists(nodes));
    }
}
