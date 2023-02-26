package l;

import java.util.HashMap;

/**
 * 两数相加，比较出名，skip
 * */
public class LeetCode001 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) return new int[2];
        HashMap<Integer, Integer> cachePre = new HashMap<Integer, Integer>();
        cachePre.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            if(cachePre.containsKey(target-nums[i])){
                return new int[]{cachePre.get(target-nums[i]),i};
            }else{
                cachePre.put(nums[i],i);
            }
        }
        return new int[2];
    }
}
