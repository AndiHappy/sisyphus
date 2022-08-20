package accumulate.linkedList;

import util.ListNode;

public class L02 {

    //-----------------------------------------------------------------------------------

    /**
     * first:describle the problem
     * two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     *
     * second: use data struct LinkedList
     * third:write the code
     * fourth: test cases;
     */
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

    public static int carry=0;
    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;
        ListNode head = new ListNode(((l1 != null?l1.val:0) + (l2 != null?l2.val:0)+carry) %10);
        carry= ((l1 != null?l1.val:0) + (l2 != null?l2.val:0)+carry)/10;
        head.next= addTwoNumbers(l1 != null?l1.next:null,l2 != null?l2.next:null);
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next=new ListNode(2);
        head1.next.next=new ListNode(2);
        head1.next.next.next=new ListNode(2);

        ListNode head2 = new ListNode(1);
        head2.next=new ListNode(2);
        head2.next.next=new ListNode(2);
        head2.next.next.next=new ListNode(8);

        System.out.println(addTwoNumbers(head1,head2));
        System.out.println(addTwoNumbers_1(head1,head2));
    }

    //-----------------------------------------------------------------------------------

}
