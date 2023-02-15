package accumulate.linkedList;

import com.sun.jdi.connect.ListeningConnector;
import util.ListNode;

public class ReverseLinkedList {

    /**
     * 临时变量在while循环中
     * */
    public static ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null) return head;
        // 1->2->3->4
        // 1 2->3->4
        // 1<-2 3->4
        // 1<-2<-3 4
        // 1<-2<-3<-4
        ListNode cur = head;
        ListNode after = head.next;
        cur.next=null;
        while (after != null){
            ListNode tmp = after.next;
            after.next = cur;
            cur= after;
            after=tmp;
        }
        return cur;
    }

    /**
     * 以这个为主
     * */
    public static ListNode reverseLinkedList_third(ListNode head){
        if(head == null || head.next == null) return head;
        // null 1->2->3->4
        // null<-1 2->3->4
        // null<-1<-2 3->4
        // null<-1<-2<-3 4
        ListNode pre = null;
        ListNode cur = head;
        ListNode after = head.next;
        while (after != null){
           cur.next=pre;
           pre=cur;
           cur=after;
           after = after.next;
        }
        cur.next=pre;
        return cur;
    }

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next = new ListNode(6);
        h1.next.next.next.next.next.next = new ListNode(7);
//        System.out.println(reverseLinkedList(h1));
        System.out.println(reverseLinkedList_third(h1));
    }
}
