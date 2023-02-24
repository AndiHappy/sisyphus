package interview.jerry.test;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingSum {
    /**
     题目是给一串数字（0 - 9）每个数字之间可以加 + - 号或者不加，组成的表达式计算结果等于 给定的目标数，输出所有满足条件的表达式。

     例如： [1 2 3 4 5 6 7 8 9]  目标 100

     可能的组合：

     1 + 23 - 4 + 56 + 7 + 8 + 9
     -1 - 2 + 34 - 5 - 6 + 78 + 9

     * */
    public List<List<String>>  combainToTarget(String nums ,int target){
        List<List<String>> result = new ArrayList<List<String>>();
        combainToTarget(nums,0,target,result,new ArrayList<String>());
        return result;
    }

    private void combainToTarget(String nums, int from, int target, List<List<String>> result,List<String> tmp) {

        for (int i = from; i < nums.length() ; i++) {
            long value = Long.parseLong(nums.substring(from,i+1));

        }
    }
}
