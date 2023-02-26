package l;

public class LeetCode004 {

    /**
     * first: describe the problem
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
     * the median of the two sorted arrays.
     * second: use method divided sort
     * third: write the code
     * fouth: test the case
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        // 举例子判断，l,r的值得判断
        // nums1，nums2 的长度分别为：（1，3）--> 总长度是： 4 --> l和r的值分别是：(2,3)
        // nums1，nums2 的长度分别为：（2，3）--> 总长度是： 5 --> l和r的值分别是：(3,3)
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (getKth(nums1,0,nums2,0,l)+getKth(nums1,0,nums2,0,r))/2.0;
    }

    /**
     * @param bstart 数组的小标
     * @param k 个数，所以k-1为为对应数据的下标步长
     * */
    public double getKth(int[] a,int astart,int[] b,int bstart,int k){
        if(astart >= a.length) return b[bstart+k-1];
        if(bstart >= b.length) return a[astart+k-1];
        // 保证k > 1
        if(k==1) return Math.min(a[astart],b[bstart]);

        int amid=Integer.MAX_VALUE,bmid=Integer.MAX_VALUE;
        if(astart+k/2-1 < a.length) amid=a[astart+k/2-1];
        if(bstart+k/2-1 < b.length) bmid=b[bstart+k/2-1];
        // k/2 至少挪动一个位置
        if(amid < bmid){
            return getKth(a,astart+k/2,b,bstart,k-k/2);
        }else{
            return getKth(a,astart,b,bstart+k/2,k-k/2);
        }
    }


    static class Solution {
        //采用熟悉的分治算法，这个需要列出来具体的排行第几的index
        //例如 【1，2，3，4】 【6，7，8】
        // 需要找到排行第4
        //例如【1，2，3，4】 【5，6，7，8】
        // 需要找到排行第4，第5 的元素
        // 如果需要统一的话，我们简单的概括为两个数组的长度为 m，n
        // 需要找到的就是第  (m+n+1)/2 ,(m+n+2)/2  位的元素
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length == 0 && nums2.length == 0) return 0;
            if(nums1.length == 0) return  (nums2[(nums2.length+1)/2-1]+nums2[(nums2.length+2)/2-1])/2.0;
            if(nums2.length == 0) return  (nums1[(nums1.length+1)/2-1]+nums1[(nums1.length+2)/2-1])/2.0;
            int m = nums1.length;
            int n = nums2.length;
            return (getKth(nums1,0,nums2,0,(m+n+1)/2)+getKth(nums1,0,nums2,0,(m+n+2)/2))/2.0;
        }

        // 找到数据组nums1，nums2 合并起来的数据的第k个元素
        public int getKth(int[] nums1,int s1,int[] nums2,int s2,int k){
            //特殊情况下的，退出条件
            if(s1 >= nums1.length) return nums2[s2+k-1];
            if(s2 >= nums2.length) return nums1[s1+k-1];
            if(k == 1) return nums1[s1] > nums2[s2]?nums2[s2]:nums1[s1];

            //挑选元素进行比较，挑选的这个元素是从起始位置开始的，步长为k/2的元素
            int s1k = s1+k/2;
            int s2k = s2+k/2;

            int s1kv = s1k > nums1.length?Integer.MAX_VALUE:nums1[s1k-1];
            int s2kv = s2k > nums2.length?Integer.MAX_VALUE:nums2[s2k-1];
            if(s1kv > s2kv){
                return getKth(nums1,s1,nums2,s2k,k-k/2);
            }else{
                return getKth(nums1,s1k,nums2,s2,k-k/2);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode004.Solution s = new LeetCode004.Solution();
        s.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }
}
