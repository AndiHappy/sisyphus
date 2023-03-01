package l;

import java.util.*;

public class LeetCode039 {




    public static void main(String[] args) {
        System.out.println("keep Happy boy");
//        casetest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},10);
        casetest(new int[]{2,3,6,7},7);
//        casetest(new int[]{2,3,5},8);
//        casetest(new int[]{2},1);
//        casetest(new int[]{1},1);
//        casetest(new int[]{1},2);
//        casetest(new int[]{2,7,6,3,5,1},9);

    }

    public static void casetest(int[] rags,int target) {
        int[] result = rags;
        List<List<Integer>> res = combinationSum(rags,target);
        for (List<Integer> tmp : res) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }
    }

    /**
     * why sorts?
     * why start i ? // ①
     * */
    public static List<List<Integer>> combinationSum_old(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, res, new ArrayList<>(), target,0);
        return res;
    }

    private static void backtracking(int[] candidates, ArrayList<List<Integer>> res, ArrayList<Integer> restmp, int target, int start) {
        if(target < 0) return;
        if(0 == target){
            res.add(new ArrayList<>(restmp));
        }else{
            for (int i = start; i < candidates.length ; i++) {
//                if(candidates[i] <= target){
                    restmp.add(candidates[i]);
//                    backtracking(candidates,res,restmp,target-candidates[i],start); ①
                backtracking(candidates,res,restmp,target-candidates[i],i);
                    restmp.remove(restmp.size()-1);
//                }
            }
        }
    }

    /**
     39. 组合总和
     给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合
     ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

     candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     对于给定的输入，保证和为 target 的不同组合数少于 150 个。

     示例 1：

     输入：candidates = [2,3,6,7], target = 7
     输出：[[2,2,3],[7]]
     解释：
     2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     7 也是一个候选， 7 = 7 。
     仅有这两种组合。
     示例 2：

     输入: candidates = [2,3,5], target = 8
     输出: [[2,2,2,2],[2,3,3],[3,5]]
     示例 3：

     输入: candidates = [2], target = 1
     输出: []


     提示：

     1 <= candidates.length <= 30
     2 <= candidates[i] <= 40
     candidates 的所有元素 互不相同
     1 <= target <= 40
     * */
//2,3,6,7
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates,target,0,new Stack<Integer>(),result);
        return result;
    }

    public static void combinationSum(int[] candidates,int target,int from,Stack<Integer> stack,List<List<Integer>> result ){
        //剪枝优化
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(stack));
        }
        for (int i = from; i < candidates.length ; i++) {
            stack.push(candidates[i]);
            if(target-candidates[i] >=0) {
                combinationSum(candidates,target-candidates[i],i,stack,result);
            }
            stack.pop();
        }
    }
}
