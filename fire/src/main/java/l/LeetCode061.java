package l;

import util.ListNode;

public class LeetCode061 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) return head;
        ListNode tmp = head;
        int length = 0;
        for (; tmp != null; tmp = tmp.next, length++) ;
        if (k >= length) k = k % length;
        if (k <= 0) return head;

        ListNode first = null;
        ListNode second = head;
        int value = length - k;
        for (; value > 0; first = second, second = second.next, value--) ;
        tmp = second;
        for (; second != null && second.next != null; second = second.next) ;
        if (second != null) second.next = head;
        if (first != null) first.next = null;
        return tmp;
    }

    public static void main(String[] args) {

        ListNode head = ListNode.construct(new int[]{1,2,3,4,5});
        for (int i = 1; i <= 10; i++) {
            head = ListNode.construct(new int[]{1,2,3,4,5});
            head = rotateRight(head,i);
            System.out.println(head);
        }
    }
}
