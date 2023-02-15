package accumulate.linkedList;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

// 重新排列链表的一个算法，从头挑选一个，从尾挑选一个。重新排列一下链表
public class ReorderLinkedList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j)  break;
            list.get(j).next = list.get(i);
            j--;
        }
        //末尾节点设置为null
        list.get(i).next = null;
    }

    public void reorderList_v(ListNode head) {
        if(head == null || head.next == null) return;
        ArrayList<ListNode> tmpStore = new ArrayList<>();
        ListNode cur = head;
        while(cur != null && tmpStore.add(cur)) cur=cur.next;
        int i=0,j=tmpStore.size()-1;
        while(i<j){
            tmpStore.get(i).next=tmpStore.get(j);
            i++;
            if(i==j) break;
            tmpStore.get(j).next=tmpStore.get(i);
            j--;
        }
        tmpStore.get(j).next=null;
    }
}
