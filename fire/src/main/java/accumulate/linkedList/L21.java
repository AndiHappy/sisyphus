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

    /**
     * 递归的写法，比较的别致
     */
    public ListNode mergeTwoLists_iterator(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists_iterator(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists_iterator(l1, l2.next);
            return l2;
        }
    }
}
