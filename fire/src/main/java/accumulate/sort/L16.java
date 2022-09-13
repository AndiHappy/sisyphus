package accumulate.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L16 {

    public static void main(String[] args) {
        System.out.println("Keep Happy!");
        System.out.println(threeSumClosest(new int[]{-4,-1,1,2},1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer result = Integer.MAX_VALUE;
        //two point interation
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j=i+1,k=nums.length-1;
            while(j < k){
                if(j>i+1 && nums[j-1] == nums[j]){
                    j++;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target){
                    return target;
                }else if(sum < target){
                    j++;
                    int compare = Math.abs(target-sum);
                    if(compare <  Math.abs(result)){
                        result=sum;
                    }

                }else{
                    k--;
                    int compare = Math.abs(sum-target);
                    if(compare < Math.abs(result)){
                        result=sum;
                    }
                }
            }
        }
        return result;
    }

    public static int threeSumClosest_big(int[] nums, int target) {
        Arrays.sort(nums);
        Integer result = null;
        //two point interation
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j=i+1,k=nums.length-1;
            while(j < k){
                if(j>i+1 && nums[j-1] == nums[j]){
                    j++;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[k];
                if(result == null ||  Math.abs(sum-target) < Math.abs(result-target)){
                    result=sum;
                }

                if(sum == target){
                    return target;
                }else if(sum < target){
                    j++;
                    while (j < k && nums[j] == nums[j-1]) j++;
                }else{
                    k--;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return result;
    }
}
