package accumulate.linkedList;

import util.ListNode;

public class L019 {
    /**
     * head= 1-->2-->3-->4-->5, n = 2
     *
     * // The number of nodes in the list is sz.
     * // 1 <= sz <= 30
     * // 0 <= Node.val <= 100
     * // 1 <= n <= sz
     *
     * 删除的是倒数第n个元素
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // head 不是null，题目中已经明确说明，不在进行判断
        ListNode first= head;
        ListNode second = head;
        // example:  head= 1-->2-->3-->4-->5, n = 2
        // 两个指针，first，second
        while(first != null && n > 0){
            first = first.next;
            n--;
        }

        // example:  head= 1-->2-->3-->4-->5, n = 5
        // 如果删除的是第一个节点，
        if(first == null && n == 0){
            return head.next;
        }

        //如果删除的不是第一个节点
        while(first.next != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {

        // 正常的删除的操作
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(removeNthFromEnd(head,5));// 1,2,3,5

        //删除尾巴
        head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.println(removeNthFromEnd(head,1));//null

        //删除头部
        head = new ListNode(1);
        head.next=new ListNode(2);
        System.out.println(removeNthFromEnd(head,2));// 4

    }
}
