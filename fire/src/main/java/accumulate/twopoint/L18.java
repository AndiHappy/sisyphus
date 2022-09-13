package accumulate.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18 {


    public static void main(String[] args) {
        System.out.println("keep happy");

        System.out.println(fourSum_normal(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));

        System.out.println(fourSum_normal(new int[]{-1,-1,-2,-2,-3,-4,-5,-6,-7,-8},-10));


//        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5},-11));


    }

    public static List<List<Integer>> fourSum_normal(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                List<List<Integer>> subsets = kSum(nums, target - nums[i], i + 1, k - 1);
                for (List<Integer> subset : subsets) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }


    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            return kSum(nums, target, 0, 4);
        }

        public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
            List<List<Integer>> res = new ArrayList<>();
            // If we have run out of numbers to add, return res.
            if (start == nums.length) {
                return res;
            }
            // There are k remaining values to add to the sum. The
            // average of these values is at least target / k.
            long average_value = target / k;

            // We cannot obtain a sum of target if the smallest value
            // in nums is greater than target / k or if the largest
            // value in nums is smaller than target / k.
            if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
                return res;
            }

            if (k == 2) {
                return twoSum(nums, target, start);
            }

            for (int i = start; i < nums.length; ++i) {
                if (i == start || nums[i - 1] != nums[i]) {
                    for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i])));
                        res.get(res.size() - 1).addAll(subset);
                    }
                }
            }

            return res;
        }

        public List<List<Integer>> twoSum(int[] nums, long target, int start) {
            List<List<Integer>> res = new ArrayList<>();
            int lo = start, hi = nums.length - 1;

            while (lo < hi) {
                int currSum = nums[lo] + nums[hi];
                if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                    ++lo;
                } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                    --hi;
                } else {
                    res.add(Arrays.asList(nums[lo++], nums[hi--]));
                }
            }

            return res;
        }
    }



    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        long average_value = target / 4;
        if  (nums[0] > average_value || average_value > nums[nums.length - 1]) {
            return result;
        }

        for (int i = 0; i < nums.length-3; i++) {
            // skip same element
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for (int j = i+1; j < nums.length-2; j++) {
                // skip same elements
                if(j>i+1 && nums[j-1] == nums[j]) continue;
                int m = j+1;int n = nums.length-1;
                while(m < n){
                    // skip same elements
                    if(m > j+1 && nums[m-1] == nums[m]){
                        m++;
                        continue;
                    }

                    long tmpSum = (long)nums[i]+(long)nums[j]+(long)nums[m]+(long)nums[n];
                    if(tmpSum < Integer.MIN_VALUE || tmpSum > Integer.MAX_VALUE){
                        break;
                    }

                    if(tmpSum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++;
                        n--;

                    }else if(tmpSum < target){
                        m++;
                    }else {
                        n--;
                    }
                }
            }
        }
        return result;
    }


}
