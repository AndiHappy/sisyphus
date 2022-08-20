package accumulate.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class L01 {

    /**

     public int[] twoSum(int[] nums, int target) {
     if(nums == null || nums.length < 2) return new int[2];
     HashMap<Integer,Integer> tmp = new HashMap<Integer,Integer>();
     tmp.put(nums[0],0);
     for(int i = 1 ; i < nums.length ; i ++){
     Integer one = tmp.get(target-nums[i]);
     if(one != null){
     return new int[]{one,i};
     }else{
     tmp.put(nums[i],i);
     }
     }
     return new int[2];
     }
     * **/
    /**
     * 1. find solution, two element,one plus another is equal to the target;
     * 2. use data structure: hashmap;
     * 3. write code;
     * 4. test case;
     */
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

    public static void main(String[] args) {
        System.out.println("Hello,World");
        int[] nums = new int[]{2,7,11,15};
        int target=9;
        int[] result =  twoSum(nums,target);
        System.out.println(Arrays.toString(result));

        nums= new int[]{3,2,4};
        target=6;
        result= twoSum(nums,target);
        System.out.println(Arrays.toString(result));

        nums= new int[]{3,3};
        target=6;
        result= twoSum(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
