package l;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode077_2 {
    class Solution {

        /**
         如果 k=2,则两层循环即可，如果 k=3，那就是三层循环
         k=50的时候，不可能 50 层循环，回溯中，这个n 就是循环的宽度，也可以说是
         树的宽度，树的深度可以说是这个 k
         循环到叶子节点，就要跳出来

         void backtracking(参数) {
         if (终止条件) {
         存放结果;
         return;
         }

         for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
         处理节点;
         backtracking(路径，选择列表); // 递归
         回溯，撤销处理结果
         }
         }
         **/
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>>  result = new ArrayList<>();
            Set<Integer> combineSet = new HashSet<>();
            combine(n,1,k,result,combineSet);
            return result;
        }
        public void combine(int n ,int from,int k,List<List<Integer>>  result,Set<Integer> combineSet ){
            if( k == 0){
                result.add(new ArrayList<>(combineSet));
                return;
            }

            //优化的点在于这个地方,回溯算法中的剪枝优化
            for(int i = from; i <= n-(k-1); i++){
                if(!combineSet.contains(i)){
                    combineSet.add(i);
                    combine(n,i+1,k-1,result,combineSet);
                    combineSet.remove(i);
                }
            }
        }
    }
}
