package l;

public class LeetCode042 {
    /**
     42. Trapping Rain Water

     Given n non-negative integers representing an elevation map where the width of each bar is 1,
     compute how much water it can trap after raining.



     Example 1:


     Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     Output: 6
     Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     In this case, 6 units of rain water (blue section) are being trapped.

     Example 2:

     Input: height = [4,2,0,3,2,5]
     Output: 9


     Constraints:

     n == height.length
     0 <= n <= 3 * 104
     0 <= height[i] <= 105

     */

    /**
     * 1. calculation area method
     * 2. two pointer
     * */
    public int trap(int[] height) {
        if(null == height || height.length < 2 ) return 0;
        int from = 0,to = height.length-1,lMax=0,rMax=0,result = 0;
        while(from < to){
            lMax = Math.max(height[from],lMax);
            rMax = Math.max(height[to],rMax);
            if (lMax < rMax){
                result = result+lMax-height[from];
                from++;
            }else {
                result = result+rMax-height[to];
                to--;
            }
        }

        return result;
    }


    class Solution {
        public int trap(int[] height) {
            if(height.length == 1) return 0;
            int[] left = new int[height.length];
            left[0] = height[0];
            for(int i =1 ; i < height.length ; i++){
                left[i] = (height[i] > left[i-1])?height[i]:left[i-1];
            }

            int[] right = new int[height.length];
            right[right.length-1] = height[height.length-1];
            for(int i = height.length-2;i>=0;i--){
                right[i] = (height[i] > right[i+1])?height[i]:right[i+1];
            }

            int result = 0;
            for(int i= 0;i < height.length;i++){
                int h = Math.min(left[i],right[i]);
                if(height[i] < h){
                    result = result + h-height[i];
                }
            }

            return result;


        }
    }
}
