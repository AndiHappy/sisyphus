
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
