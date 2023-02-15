package accumulate.linkedList;

import util.ListNode;

public class CycleLinkedList {

    public ListNode findMeetPoint(ListNode head) {
        if(head ==null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //快慢指针相等表示有环
            if(slow==fast){
                //回到起点一起相同速度走，快节点以相同的速度走
                while(head!=fast){
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }
        }
        return null;
    }


    //判断是否有环
    public static boolean hasCycle(ListNode head ){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
