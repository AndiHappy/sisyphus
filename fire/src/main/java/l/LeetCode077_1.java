package l;

import java.util.*;

/**

 77. 组合
 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

 你可以按 任何顺序 返回答案。



 示例 1：

 输入：n = 4, k = 2
 输出：
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 示例 2：

 输入：n = 1, k = 1
 输出：[[1]]


 提示：

 1 <= n <= 20
 1 <= k <= n


 * **/
public class LeetCode077_1 {

    /**
     * 典型的回溯算法，首先我们确定 for 循环的遍历的宽度，挑选第一个，第二个，第三个，第 K 个，应该是遍历
     * 的深度，达到叶子节点，也就是第 k 个节点的时候，直接返回
     * 
     * 遍历的宽度，也就是第一个挑选元素的范围
     * */

    public static void main(String[] args) {
        LeetCode077_1 leetCode077 = new LeetCode077_1();
        List<List<Integer>> result = leetCode077.combine(4,2);
        for (List e: result){
            System.out.println(Arrays.toString(e.toArray()));
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> combineSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            combineSet.add(i);
            combine(n,i+1,k-1,combineSet,result);
            combineSet.remove(i);
        }
        return result;
    }


    private void combine(int n, int from,int i, Set<Integer> combineSet,List<List<Integer>>  result) {
        if(i ==0){
            result.add(new ArrayList<>(combineSet));
            return;
        }
        for (int j = from; j <= n; j++) {
            combineSet.add(j);
            combine(n,from+1,i-1,combineSet,result);
            combineSet.remove(j);
        }
    }
}
