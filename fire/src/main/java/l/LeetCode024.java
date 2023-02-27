package l;

import util.ListNode;

public class LeetCode024 {

    public static  ListNode swapPairs_2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode pre = tmp;
        ListNode after = head.next;
        while(head != null && head.next != null){
            head.next=after.next;
            after.next=head;
            pre.next=after;
            pre = pre.next.next;
            if(pre != null && pre.next != null){
                head = pre.next;
            }
            if(head != null && head.next != null){
                after=head.next;
            }
        }

        return tmp.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        return swapPairs(head,head.next);
    }

    private static ListNode swapPairs(ListNode head, ListNode next) {
        head.next = next.next;
        next.next=head;
        if(head.next != null && head.next.next != null){
            head.next = swapPairs(head.next, head.next.next);
        }
        return next;
    }

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next = new ListNode(6);

        System.out.println(swapPairs(h1));


    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null||lists.length ==0) return null;
            if(lists.length == 1) return lists[0];
            return mergeKLists(0,lists.length-1,lists);
        }

        public ListNode mergeKLists(int from,int end,ListNode[] lists){
            if(from == end) return lists[from];
            int mid = from + (end-from)/2;
            ListNode pm = mergeKLists(from,mid,lists);
            ListNode am = mergeKLists(mid+1,end,lists);
            return mergeTwoLists(pm,am);
        }

        public ListNode mergeTwoLists(ListNode s1,ListNode s2){
            if(s1 == null) return s2;
            if(s2 == null) return s1;
            int val = s1.val > s2.val ? s2.val:s1.val;
            return new ListNode(val,s1.val > s2.val? mergeTwoLists(s1,s2.next):mergeTwoLists(s1.next,s2));
        }
    }
}
