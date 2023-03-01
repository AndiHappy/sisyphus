package l;

public class LeetCode034_1 {

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10},8);
    }
    /**
     二分法非常的简单，但是二分法的细节
     **/
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length ==0) return new int[]{-1,-1};

        int startIndex=0;
        int from =0,to = nums.length;
        while(from < to){
            int mid = from+(to-from)/2;
            if(nums[mid] <target){
                from=mid;
            }else{
                to=mid;
            }
        }

        if(from < nums.length-1){
            if(nums[from+1] == target) {
                startIndex=from+1;
                System.out.print(startIndex);
            }else{
                return new int[]{-1,-1};
            }
        }

        return new int[]{-1,-1};

    }
}
