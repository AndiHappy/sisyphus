package accumulate.sort;

public class L04 {

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
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (getKth(nums1,0,nums2,0,l)+getKth(nums1,0,nums2,0,r))/2.0;
    }

    public double getKth(int[] a,int astart,int[] b,int bstart,int k){
        if(astart >= a.length) return b[bstart+k-1];
        if(bstart >= b.length) return a[astart+k-1];
        if(k==1) return Math.min(a[astart],b[bstart]);

        int amid=Integer.MAX_VALUE,bmid=Integer.MAX_VALUE;
        if(astart+k/2-1 < a.length) amid=a[astart+k/2-1];
        if(bstart+k/2-1 < b.length) bmid=b[bstart+k/2-1];
        if(amid < bmid){
            return getKth(a,astart+k/2,b,bstart,k-k/2);
        }else{
            return getKth(a,astart,b,bstart+k/2,k-k/2);
        }
    }


    public static void main(String[] args) {

    }
}
