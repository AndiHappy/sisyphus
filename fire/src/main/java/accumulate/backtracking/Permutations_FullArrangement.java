package accumulate.backtracking;

import java.util.*;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
public class Permutations_FullArrangement {

    //全排列，即所有路径集合
    private static List<List<Integer>> allPath = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        //当前路径，入口路径，path是空的
        LinkedList<Integer> path =  new LinkedList<>();
        //递归函数入口，可做选择是nums数组
        backTrace(nums,path);
        return allPath;
    }

    private static void backTrace(int[] nums, LinkedList<Integer> path) {
        //已经走过的path数组等于nums的长度，说明已经走到了叶子节点
        if(nums.length == path.size()) {
            allPath.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //剪枝，排查已经走过的路径
            if(path.contains(nums[i])) continue;
            //走路，编排，注意外面的for循环
            path.add(nums[i]);
            // 递归的编排
            backTrace(nums,path);
            //已经走过的，回滚
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

        int[] v = new int[]{1,2,3};
        List<List<Integer>> vs = permute(v);
        for (int i = 0; i < vs.size(); i++) {
            System.out.println(Arrays.toString(vs.get(i).toArray()));
        }

    }
}
