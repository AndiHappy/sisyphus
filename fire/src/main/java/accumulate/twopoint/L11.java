package accumulate.twopoint;

public class L11 {

    /**
     * first: desrible the problem

     You are given an integer array height of length n. There are n vertical lines
     drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     Find two lines that together with the x-axis form a container, such that the
     container contains the most water.
     Return the maximum amount of water a container can store.
     Notice that you may not slant the container.

     second: use iteration_control

     third:write the code
     fourth: test the case
     * */

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

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }

}
