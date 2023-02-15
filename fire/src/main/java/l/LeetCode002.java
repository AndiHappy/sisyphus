package l;

import util.ListNode;

public class LeetCode002 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode current = new ListNode(-1);
        ListNode head =current;
        int carry = 0;
        while(l1 != null || l2 != null){
            int value = (l1 != null?l1.val:0)+(l2 != null?l2.val:0)+carry;
            current.next=new ListNode(value%10);
            carry=value/10;
            current=current.next;
            l1=l1 != null?l1.next:null;
            l2=l2 != null?l2.next:null;
        }
        if(carry >0) current.next=new ListNode(carry);
        return head.next;
    }
}
