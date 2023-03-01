package l;

import java.util.*;

public class LeetCode216 {
    /**
     *
     216. 组合总和 III
     找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

     只使用数字1到9
     每个数字最多使用一次
     返回所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。



     示例 1:

     输入: k = 3, n = 7
     输出: [[1,2,4]]
     解释:
     1 + 2 + 4 = 7
     没有其他符合的组合了。
     示例 2:

     输入: k = 3, n = 9
     输出: [[1,2,6], [1,3,5], [2,3,4]]
     解释:
     1 + 2 + 6 = 9
     1 + 3 + 5 = 9
     2 + 3 + 4 = 9
     没有其他符合的组合了。
     示例 3:

     输入: k = 4, n = 1
     输出: []
     解释: 不存在有效的组合。
     在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
     * ***/

    /**
     * 如果k=1,则需要遍历 【1，9】
     * 如果k=2，则需要二次循环，并且第二次的 target依赖于第一次的循环
     * 所以需要遍历的次数为 k，或者说深度是 k，遍历的叶子节点，返回的条件是：和 target 相等
     * */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> set = new Stack<>();
        combinationSum3( k,1,n,result,set);
        return result;
    }

    private void combinationSum3(int k, int from, int n, List<List<Integer>> result, Stack<Integer> set) {
        if( set.size() == k && n ==0){
            result.add(new ArrayList<>(set));
            return;
        }
        for (int j = from; j <=9 ; j++) {
            if(!set.contains(j)){
                set.push(j);
                combinationSum3(k,j+1,n-j,result,set);
                set.pop();
            }
        }
    }

    public static void main(String[] args) {
        LeetCode216 test = new LeetCode216();
        List<List<Integer>>  result = test.combinationSum3(3,9);
        for (List l: result){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
