package accumulate.linkedList;

import util.ListNode;

public class L25 {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next = new ListNode(6);
        h1.next.next.next.next.next.next = new ListNode(7);
        System.out.println(reverseKGroup(h1,3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(-1);
        dump.next=head;
        ListNode cur = dump;
        ListNode pre = dump;
        // 1->2->3->4->5->6->7
        while(cur != null){
            int count = k;
            while(count>0 && cur != null){
                cur=cur.next;
                count--;
            }
            if(cur == null) break;
            reverse(pre,cur);
        }
        return dump.next;
    }

    private static void reverse(ListNode pre, ListNode end) {
        //1->2->3->4
        ListNode cur = pre.next;
        ListNode after = end.next;
        while(cur != end){

        }
    }


    private static ListNode find(ListNode head, int k) {
        while(k > 1 && head != null) {
            head=head.next;
            k--;
        }
        return head;
    }

    /**
     * 必须有模拟的数据来展示，编码的过程
     * pre -1->1->2->3->4 k=3
     * */
    private static ListNode reverseLinkedList(ListNode pre, int k) {
        ListNode preMove = pre; // -1
        ListNode head = pre.next;// 1
        ListNode cur = pre.next; // 1
        while(k > 1 && cur != null) {
            cur=cur.next;
            k--;
        }
        //k==1,cur=3,如果k>length,cur==null
        if(cur == null){
            return null;
        }else{
            pre.next=cur.next;
        }
        return pre;
    }
}
