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
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (getKth(nums1,0,nums2,0,l)+getKth(nums1,0,nums2,0,r))/2.0;
    }

    public static double getKth(int[] a,int astart,int[] b,int bstart,int k){
        if(astart >= a.length) return b[bstart+k-1];
        if(bstart >= b.length) return a[astart+k-1];
        if(k==1) return Math.min(a[astart],b[bstart]);



        int amid=0,bmid=0;
        if(astart+k/2 -1 < a.length){
            amid = a[astart+k/2-1];
        }else{
            //  类似a= [3] b= [1,2,4,5,6] ,数组长度就是1，5，
            //  需要查找的是第3和第4个小的元素，如果是第4个元素，那么针对a的数据，已经超出了a的范围
            //  那就需要先判断b的元素列表
            return getKth(a,astart,b,bstart+k/2,k-k/2);
        }
        if(bstart + k/2 - 1 < b.length){
            bmid = b[bstart+k/2-1];
        }else{
            return getKth(a,astart+k/2,b,bstart,k-k/2);
        }

        //或者替换为我们常见的方式
        /**
         * int amid=Integer.MAX_VALUE,bmid=Integer.MAX_VALUE;
         * if(astart+k/2-1 < a.length) amid=a[astart+k/2-1];
         * if(bstart+k/2-1 < b.length) bmid=b[bstart+k/2-1];
         * */
        //

        if(amid < bmid){
            return getKth(a,astart+k/2,b,bstart,k-k/2);
        }else{
            return getKth(a,astart,b,bstart+k/2,k-k/2);
        }
    }


    public static double findMedianSortedArrays_mid(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // make sure m <= n
        if (m > n)
            return findMedianSortedArrays(B, A);

        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = (m + n + 1) / 2 - i;

            int A_left = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int A_right = i == m ? Integer.MAX_VALUE : A[i];
            int B_left = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int B_right = j == n ? Integer.MAX_VALUE : B[j];
            System.out.println("i: "+i + " j: "+j + " A_left: "+ A_left + " A_right: "+ A_right + " B_left: "+ B_left + " B_right: "+ B_right);
            if (A_left > B_right) {
                imax = i - 1;
            } else if (B_left > A_right) {
                imin = i + 1;
            } else {
                int max_left = A_left > B_left ? A_left : B_left;
                int min_right = A_right > B_right ? B_right : A_right;
                if ((m + n) % 2 == 1)
                    return max_left; // # of left_part = # of right_part + 1;
                else
                    return (max_left + min_right) / 2.0;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{3},new int[]{1,2,4,5,6}));
    }
}
