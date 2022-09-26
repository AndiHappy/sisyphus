package accumulate.sort;

import java.util.Arrays;

public class L34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange_iterator(new int[]{5,7,7,7,7,7,7,10},7)));
    }

    public static int[] searchRange_iterator(int[] nums,int target){
        int[] result = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return result;
        int from =0,to=nums.length-1;
        while(from < to){
            int mid = from+(to-from)/2;
            if(nums[mid] < target) from=mid+1;
            else to=mid;
        }
        if(nums[from] == target) result[0]=from;
        else return result;

        to = nums.length-1;
        while(from < to){
            int mid = from+(to-from)/2+1;
            if(nums[mid] > target) to = mid-1;
            else from=mid;
        }
        result[1]=to;
        return result;
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]=findFirstIndex(nums,target);
        result[1]=findLastIndex(nums,target);
        return result;
    }

    private static int findFirstIndex(int[] nums, int target) {
        int from = 0,to=nums.length,mid=0,in=-1;
        while(from <= to){
            mid = from+(to-from)/2;
            if(nums[mid] == target){
                in=mid;
                to = mid-1;
            } else if (nums[mid] > target) {
                to=mid-1;
            }else{
                from = mid+1;
            }
        }
        return in;
    }

    private static int findLastIndex(int[] nums, int target) {
        int from = 0,to=nums.length,mid=0,in=-1;
        while(from <= to){
            mid = from+(to-from)/2;
            if(nums[mid] == target){
                in=mid;
                from = mid+1;
            } else if (nums[mid] > target) {
                to=mid-1;
            }else{
                from = mid+1;
            }
        }
        return in;
    }


}
