package accumulate.iteration_control;

import util.ListNode;

public class L23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        if(lists.length == 1) return lists[0];
        return merge(lists,0,lists.length-1);
    }


    public static ListNode merge(ListNode[] listNodes,int from,int to){
        if(from == to) return listNodes[from];
        int mid = from+ (to-from)/2;
        ListNode firstPart = merge(listNodes,from,mid);
        ListNode secondPart = merge(listNodes,mid+1,to);
        return mergeTwoList(firstPart,secondPart);
    }


    /**
     * 迭代的比较标准和好玩的一个点
     * 其中有一个合并的数据
     * */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        return l1.val < l2.val? new ListNode(l1.val,mergeTwoList(l1.next,l2)) : new ListNode(l2.val,mergeTwoList(l1,l2.next));
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
    }
}
