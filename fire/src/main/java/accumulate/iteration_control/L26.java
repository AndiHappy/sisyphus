package accumulate.iteration_control;

public class L26 {


    /**
     * 迭代的控制
     * */
    public static int removeDuplicates(int[] nums){
        if(nums == null) return 0;
        if(nums.length <= 1) return nums.length;
        int from=1,noDupIndex=0;
        while(from < nums.length){
            if(nums[noDupIndex] != nums[from]){
                noDupIndex++;
                nums[noDupIndex] = nums[from];
            }
            from++;
        }
        return noDupIndex+1;
    }
}
