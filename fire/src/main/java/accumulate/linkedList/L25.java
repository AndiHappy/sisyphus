package accumulate.linkedList;

import util.ListNode;

public class L25 {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next = new ListNode(6);
        System.out.println(reverseKGroup(h1,7));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(-1);
        dump.next=head;
        while(head != null){
            head = reverseLinkedList(dump,k);
        }
        return dump.next;
    }

    private static ListNode reverseLinkedList(ListNode pre, int k) {
        ListNode preMove = pre;
        ListNode cur = pre.next;
        while(k > 1 && cur != null) {
            cur=cur.next;
            k--;
        }
        if(cur == null) return null;



        return pre;
    }
}
