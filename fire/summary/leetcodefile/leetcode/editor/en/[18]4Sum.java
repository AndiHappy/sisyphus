
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

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
                    int tmpSum = nums[i]+nums[j]+nums[m]+nums[n];
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

    public static void main(String[] args) {
        System.out.println("keep happy");

        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));

        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5},-11));


    }
}
//leetcode submit region end(Prohibit modification and deletion)
