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
        h1.next.next.next.next.next.next = new ListNode(7);
        System.out.println(reverseKGroup(h1,2));
        h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next = new ListNode(6);
        h1.next.next.next.next.next.next = new ListNode(7);

        System.out.println(reverseKGroup(h1,3));
//        System.out.println(swapPairs(h1));
//        System.out.println((h1.next.next.next));
//        System.out.println(swapPairs(h1.next.next.next));
//        System.out.println((h1.next.next.next.next));
//        System.out.println(swapPairs(h1.next.next.next.next));
    }

    /**
     * 统一的解法
     * */
    private static ListNode swapPairs(ListNode h1) {
        return reverseKGroup(h1,2);
    }

    /**
     *
     * */
    private static  ListNode reverseKGroup(ListNode head,int k){
        if(head == null || k==1) return head;
        // 首先找到截止的那个元素在
        ListNode cur = head;
        for (int i = 1; i< k; i++){
            cur=cur.next;
            if(cur == null) return head;
        }

        ListNode next = cur.next;
        ListNode newHead = reverse(head,cur);
        head.next = reverseKGroup(next,k);
       return newHead;
    }

    /**
     * 1->2->3->4->
     * 4->3->2->1->
     *
     * 采用的是头插法，变化为：
     * 2->3->4->1->
     * 3->4->2->1->
     * 4->3->2->1->
     * 传入之前为链表的前后两个节点
     * 一番操作后，还是那两个节点，只不过成员变量发生了变化
     * */
    private static ListNode reverse(ListNode head, ListNode end) {
        while(head != end){
            ListNode tmp = head.next;
            head.next = end.next;
            end.next= head;
            head=tmp;
        }
        return end;
    }

    private static ListNode swapPairs_iterator(ListNode h1) {
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
            }
            // 转移后的链表
            // -1->2->1(pre)->3(cur)->4(after)
        }
        return dump.next;
    }

}
