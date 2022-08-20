//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 
// 👍 8686 👎 412


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
    /**
     * 1-->2-->3-->4-->5, 2
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return head;
        ListNode cur = head;
        ListNode pre = head;
        while(n >0){
            cur=cur.next;
            n--;
        }
        if(cur==null)return head.next;

        while(cur.next != null){
            cur=cur.next;
            pre=pre.next;
        }

        if(pre.next != null){
            pre.next=pre.next.next;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
