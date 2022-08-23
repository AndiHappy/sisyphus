package accumulate.linkedList;

import util.ListNode;

public class L21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dump = new ListNode(-1);
        ListNode head = dump;
        while(list1 != null || list2 != null){
            if(list1 == null) {
                head.next=list2;
                break;
            }
            if(list2 == null){
                head.next=list1;
                break;
            }
            if(list1.val > list2.val){
                head.next=list2;
                list2=list2.next;
            }else{
                head.next=list1;
                list1=list1.next;
            }
            head=head.next;
        }
        return dump.next;

    }
}
