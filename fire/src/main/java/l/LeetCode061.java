package l;

import util.ListNode;

public class LeetCode061 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) return head;
        ListNode tmp = head;
        int length = 0;
        while (tmp!=null){
            tmp = tmp.next; length++;
        }

        k = k >= length?k % length:k;
        if (k == 0) return head;

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

        ListNode head = ListNode.construct(new int[]{1, 2, 3, 4, 5});
        for (int i = 1; i <= 10; i++) {
            head = ListNode.construct(new int[]{1, 2, 3, 4, 5});
            head = rotateRight(head, i);
            System.out.println(head);
        }
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
        public ListNode rotateRight(ListNode head, int k) {
            // 特殊情况处理
            if(head == null || head.next == null) return head;
            int length =0;
            ListNode cur = head;
            while(cur != null){
                length++;
                cur=cur.next;
            }

            if(k >= length){
                k=k%length;
            }
            if(k ==0){
                return head;
            } else{
                // 首先确认前一个节点
                ListNode pre = head;
                int left = length-k;
                while(left >1 && pre != null){
                    pre = pre.next;
                    left--;
                }
                // 1,2,3,4,5 pre=3
                ListNode tail = pre.next;
                pre.next = null;
                if(tail != null){
                    ListNode tailA = tail;
                    while(tailA.next != null) tailA = tailA.next;
                    tailA.next = head;
                }
                return tail;
            }
        }
    }
}
