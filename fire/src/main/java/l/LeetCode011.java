package l;//Given n non-negative integers a1, a2, ..., an , where each represents a point
//at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x
//-axis forms a container, such that the container contains the most water. 
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
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: height = [4,3,2,1,4]
//Output: 16
// 
//
// Example 4: 
//
// 
//Input: height = [1,2,1]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics Array Two Pointers 
// 👍 7901 👎 646


public class LeetCode011 {

    public static int maxArea(int[] height) {
        if(height == null || height.length <2) return 0;
        int max = 0; int from = 0;int to = height.length-1;
        while(from<to){
            max = Math.max(max, (to-from)* Math.min(height[from],height[to]));
            if(height[from] > height[to]){
                to--;
            }else{
                from++;
            }
        }
        return max;
    }

    class Solution {

        // rain water
        public int maxArea(int[] height) {
            //首先去确定左右两侧存储水量的最高值，然后再去计算最大值
            int l=0,r=height.length-1;
            int maxArea = 0;
            while(l < r){
                int minH = Math.min(height[l],height[r]);
                maxArea = Math.max(minH*(r-l),maxArea);
                while( l < r && height[l] <= minH){
                    l++;
                }
                while( l < r && height[r] <= minH){
                    r--;
                }

            }
            return maxArea;


            // int[] left = new int[height.length];
            // left[0] = height[0];
            // int[] right = new int[height.length];
            // right[right.length-1] = height[height.length-1];

            // for(int i = 1 ,j=height.length-2; i< height.length && j >=0 ;i++,j--){
            //     left[i] = height[i] > left[i-1]?height[i]:left[i-1];
            //     right[j] = height[j] > right[j+1]?height[j]:right[j+1];
            // }

            // int i =0,j=height.length-1;
            // int result = 0;
            // while(i<j){
            //         result = Math.max(Math.min(left[i],right[j]) * (j-i),result);
            //         if(left[i] > right[j]){
            //             j--;
            //         }else{
            //             i++;
            //         }
            // }
            // return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("hello holia");
        System.out.println(maxArea(new int[]{ 1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[] { 1, 1 }));

        System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));

        System.out.println(maxArea(new int[] { 1, 2, 1 }));

        System.out.println(maxArea(new int[] { 1, 1,3,4,5,1,1,1,1 }));

    }
}
