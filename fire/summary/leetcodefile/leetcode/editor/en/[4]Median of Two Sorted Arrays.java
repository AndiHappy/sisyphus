//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics Array Binary Search Divide and Conquer 
// 👍 18305 👎 2143

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
        // （1，3）--> 4 --> (2,3)
        // （2，3）--> 5 --> (3,3)
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
}
//leetcode submit region end(Prohibit modification and deletion)
