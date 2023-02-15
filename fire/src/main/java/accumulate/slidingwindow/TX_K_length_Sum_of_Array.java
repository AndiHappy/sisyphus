package accumulate.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TX_K_length_Sum_of_Array {
    /**
     *
     给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
     示例：
     输入：[2，3，4，2，6，2，5，1]，3
     输出：[4，4，6，6，6，5]
     * */
    private static int errorFlag = 0;
    public static List<Integer> ksum_iterator(int[] nums, int k){
        int max = 0; int fromIndex=0;
        if(nums == null || nums.length == 0 || nums.length < k ) return new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {
            int tempSumK = 0;
            for (int j = i; j <i+k ; j++) tempSumK+=nums[j];
            if(tempSumK> max){
                max=tempSumK;
                fromIndex=i;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = fromIndex; i <fromIndex+k ; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    public static List<Integer> ksum(int[] nums, int k){
        int max = 0; int fromIndex=0; int sumWindow=0;
        if(nums == null || nums.length == 0 || nums.length < k ) return new ArrayList<>();

        for (int i = 0; i <nums.length; i++) {
            if(i < k){
                sumWindow+=nums[i];
                max=sumWindow;
                continue;
            }else{
                sumWindow = sumWindow-nums[i-k]+nums[i];
                if(sumWindow>max){
                    max=sumWindow;
                    fromIndex=i-k+1;
                }
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = fromIndex; i <fromIndex+k ; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,6,2,5};
        System.out.println(Arrays.toString(ksum(nums,3).toArray()));
    }
}
