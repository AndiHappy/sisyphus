package accumulate.iteration_control;

import util.ListNode;

import java.util.List;

public class L24 {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next = new ListNode(6);
//        System.out.println(swapPairs(h1));
//        System.out.println((h1.next.next.next));
//        System.out.println(swapPairs(h1.next.next.next));
        System.out.println((h1.next.next.next.next));
        System.out.println(swapPairs(h1.next.next.next.next));
    }

    private static ListNode swapPairs(ListNode h1) {
        if(h1 == null || h1.next == null) return h1;
        ListNode dump = new ListNode(-1);
        dump.next=h1;
        ListNode pre = dump;
        ListNode cur = h1;
        while(cur != null && cur.next != null){
            // dump->cur->after->3->4
            ListNode after = cur.next;
            // cur =1,after=2
            pre.next=after;
            cur.next=after.next;
            after.next=cur;

            //下一次转移前的判断
            if(cur != null && cur.next != null){
                // pre->after->cur->3->4
                pre = after.next;
                cur = cur.next;
                after = cur.next;
            }
            // 转移后的链表
            // -1->2->1(pre)->3(cur)->4(after)
        }
        return dump.next;
    }

}
