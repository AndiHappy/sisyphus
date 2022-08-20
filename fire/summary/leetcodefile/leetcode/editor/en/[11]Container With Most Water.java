//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics Array Two Pointers Greedy 
// 👍 18875 👎 1028

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int maxArea(int[] height) {
        int from=0,to=height.length-1;
        int result=0;
        while(from<to){
            int left=height[from],right=height[to];
            int h = Math.min(left,right);
            int cur = h*(to-from);
            if(cur>result){
                result=cur;
            }
            if(left>right){
                to--;
                while (height[to] < right) to--;
            }else{
                from++;
                while (height[from] < left) from++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
