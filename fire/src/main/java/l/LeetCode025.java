package l;

import util.ListNode;

public class LeetCode025 {

//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list.
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is.
//
// Follow up:
//
//
// Could you solve the problem in O(1) extra memory space?
// You may not alter the values in the list's nodes, only nodes itself may be changed.
//
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
//
//
// Example 2:
//
//
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
//
//
// Example 3:
//
//
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
//
//
// Example 4:
//
//
//Input: head = [1], k = 1
//Output: [1]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range sz.
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode cur = head;
        ListNode kcur = head;
        int ktmp = k;
        while(kcur != null && ktmp > 1){
            kcur = kcur.next;
            ktmp--;
        }
        return reverseKGroup(cur,kcur,k);
    }

    public static ListNode reverseKGroup(ListNode head, ListNode kcur,int k) {
        if(kcur == null){
            return head;
        }else {
            // change
            // 0==>1==>2==>3==>4
            // 1==>2==>3==>0==>4
            // 2==>3==>1==>0==>4
            // 3==>2==>1==>0==>4
            ListNode headStore = head;

            ListNode headtmp = head;
            while(headtmp != kcur){
                headtmp = head.next;
                head.next=kcur.next;
                kcur.next=head;
                head = headtmp;
            }

            int ktmp = k;
            ListNode kcurAnother = headStore.next;
            while(kcurAnother != null && ktmp > 1){
                kcurAnother = kcurAnother.next;
                ktmp--;
            }

            headStore.next=reverseKGroup(headStore.next,kcurAnother,k);

            return kcur;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode h1 = new ListNode(1);
        head.next=h1;
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next= new ListNode(5);
        h1.next.next.next.next.next= new ListNode(6);
        h1.next.next.next.next.next.next = new ListNode(7);
        h1.next.next.next.next.next.next.next = new ListNode(8);
        h1.next.next.next.next.next.next.next.next = new ListNode(9);
        h1.next.next.next.next.next.next.next.next.next = new ListNode(10);
//        h1.next.next.next.next.next.next.next.next.next.next = new ListNode(11);

//  0,1,2,3,4,5,6,7,8,9,10,11
//  3,2,1,0,4,5,6,7,8,9,10,11
//  3,2,1,0,7,6,5,4,7,8,9,10,11
//  3,2,1,0,7,6,5,4,10,9,8,7,11

//        System.out.println(reverseKGroup(head,13));
        System.out.println(LeetCode025.Solution.reverseKGroup(head,2));
    }

    //两两进行交换，需要写下详细操作的过程
    // 1->2->3->4->5->6->7
    // 0 1->2->3->4->5->6->7
    // 0 1 2->3->4->5->6->7
    // 0 1<-2  3->4->5->6->7
    // 0 1<-2<-3  4->5->6->7
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        ListNode after = head.next;
        while(after != null){
            //第一个节点尾巴设置为null
            if(pre.next == head){
                cur.next=null;
            }else{
                cur.next = pre;
            }
            pre = cur;
            cur = after;
            after = after.next;
        }
        return after;
    }


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
         翻转K个节点，其中：k 是一个正整数，它的值小于或等于链表的长度
         首先是找到开始节点，以及结束节点，开始节点的头一个节点
         1，，k->k+1,,,k+k->2k+1,,,2k+k
         */
        public static ListNode reverseKGroup(ListNode head, int k) {
            if(k == 1) return head;
            ListNode result = null;
            ListNode pre = null;
            ListNode cur = head;
            while(cur != null){
                ListNode kAfterCur =findkAfterCur(cur,k);
                if(kAfterCur != null){
                    ListNode trans = swap(cur,kAfterCur);
                    if(pre != null){
                        pre.next=trans;
                    }else if(result == null){
                        result=trans;
                    }
                    pre = cur;
                    cur = cur.next;
                }else{
                    break;
                }

            }
            return result;
        }

        private static ListNode swap(ListNode cur, ListNode kAfterCur) {
            while(cur != kAfterCur){
                ListNode tmp = cur.next;
                cur.next = kAfterCur.next;
                kAfterCur.next=cur;
                cur = tmp;
            }
            return kAfterCur;
        }

        private static ListNode findkAfterCur(ListNode cur, int k) {
            while(cur!=null && k>1){
                cur=cur.next;
                k--;
            }
            return cur;
        }
    }
}
