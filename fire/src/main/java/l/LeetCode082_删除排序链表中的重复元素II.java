package l;

import util.ListNode;

public class LeetCode082_删除排序链表中的重复元素II {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        pre.next= head;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            while (next != null && next.val == cur.val) next = next.next;
            pre.next = next;
            cur = next;
        }
        return pre.next;
    }
}
