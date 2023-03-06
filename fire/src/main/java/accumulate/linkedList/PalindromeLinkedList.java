package accumulate.linkedList;

import util.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {

    }

    /**
     * 一个 likedList 存储是字符串，判断是否是回文字符串
     *
     * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。
     * **在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序**。
     * 最后比较中点两侧的链表是否相等。
     * */
    // 1 2 3 4 5
    // 1 2 3 4 5 6
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast=fast.next.next;
            // 修改前面的节点值
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            if(slow.val != pre.val){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
