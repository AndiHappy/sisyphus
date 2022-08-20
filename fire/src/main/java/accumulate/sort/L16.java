package accumulate.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L16 {
    public static int threeSumClosest(int[] nums, int target) {
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
