package l;

import java.util.*;

public class LeetCode078 {

    /**
     *
     78. 子集
     给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

     解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



     示例 1：

     输入：nums = [1,2,3]
     输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     示例 2：

     输入：nums = [0]
     输出：[[],[0]]


     提示：

     1 <= nums.length <= 10
     -10 <= nums[i] <= 10
     nums 中的所有元素 互不相同

     * */

    public static void main(String[] args) {
        LeetCode078.Solution test = new LeetCode078.Solution();
        List<List<Integer>> r =test.subsets(new int[]{1,2,3});
        for(List l:r){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>>  result = new ArrayList<>();
            result.add(new ArrayList<>());
            ArrayList<Integer> path = new ArrayList<>();
            Set<Integer> set = new HashSet<Integer>();
            for(int i=0;i<nums.length;i++){
                if(!set.contains(nums[i])){
                    path.add(nums[i]);
                    set.add(nums[i]);
                    subsets(nums,i+1,path,set,result);
                    path.remove(path.size()-1);
                    set.remove(nums[i]);
                }

            }
            return result;
        }

        private void subsets(int[] nums,int from,ArrayList<Integer> path ,Set<Integer> set ,List<List<Integer>>  result){

            if(path.size() <= nums.length){
                result.add(new ArrayList<>(path));
            }
            for (int i = from; i< nums.length ; i++) {
                if(!set.contains(nums[i])){
                    path.add(nums[i]);
                    set.add(nums[i]);
                    subsets(nums,i+1,path,set,result);
                    path.remove(path.size()-1);
                    set.remove(nums[i]);
                }
            }

        }
    }
}
