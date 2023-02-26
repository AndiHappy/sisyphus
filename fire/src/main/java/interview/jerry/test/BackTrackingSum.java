package interview.jerry.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BackTrackingSum {
    /**
     题目是给一串数字（0 - 9）每个数字之间可以加 + - 号或者不加，组成的表达式计算结果等于 给定的目标数，输出所有满足条件的表达式。

     例如： [1 2 3 4 5 6 7 8 9]  目标 100

     可能的组合：

     1 + 23 - 4 + 56 + 7 + 8 + 9
     -1 - 2 + 34 - 5 - 6 + 78 + 9

     * */

    public static void main(String[] args) {
        List<List<String>>  result = combainToTarget("12345",0);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }
    }

    public static List<List<String>>  combainToTarget(String nums ,int target){
        List<List<String>> result = new ArrayList<List<String>>();
        combainToTarget(nums,0,target,result,new ArrayList<String>());
        return result;
    }

    private static void combainToTarget(String nums, int from, int target, List<List<String>> result,List<String> tmp) {
        for (int i = from+1; i <=nums.length() ; i++) {
            String subString = nums.substring(from,i);
            int value = Integer.parseInt(subString);
            tmp.add(subString);
//            if(i == nums.length()){
//                System.out.println(Arrays.toString(tmp.toArray()));
//            }
            if(i == nums.length() && value == target){
                result.add(new ArrayList<>(tmp));
//                tmp.remove(tmp.size()-1);
//                return;
            }
            combainToTarget(nums,i,target-value,result,tmp);
            tmp.remove(tmp.size()-1);

            tmp.add("-"+subString);
//            if(i == nums.length()){
//                System.out.println(Arrays.toString(tmp.toArray()));
//            }
            if(i == nums.length() && (-value) == target){
                result.add(new ArrayList<>(tmp));
//                tmp.remove(tmp.size()-1);
//                return;
            }
            combainToTarget(nums,i,target+value,result,tmp);
            tmp.remove(tmp.size()-1);

        }
    }


}
