package accumulate.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39 {
    public static void main(String[] args) {
        System.out.println("Keep Moving! ");

        List<List<Integer>> result = combinationSum(new int[]{2,3,6,7},7);
        for (List tmp : result) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }

        result = combinationSum(new int[]{2,3,5},8);
        for (List tmp : result) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }

        result = combinationSum(new int[]{2},1);
        for (List tmp : result) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates,target,result,new ArrayList<Integer>(),0);
        return result;
    }

    private static void combinationSum(int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> sums,int index) {
        if(index >= candidates.length) return;
        if(target == 0) {
            result.add(new ArrayList<>(sums));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(candidates[i] <= target){
                sums.add(candidates[i]);
                combinationSum(candidates,target-candidates[i],result,sums,i);
                sums.remove(sums.size()-1);
            }
        }
    }
}
