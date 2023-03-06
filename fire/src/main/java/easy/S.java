package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S {
    public static void main(String[] args) {
        S test = new S();
        List<List<Integer>>  r = test.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        for (List l:r){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cache = new ArrayList<Integer>();
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates,0,target);
        return result;
    }

    public void combinationSum2(int[] candidates,int from,int target){
        if(from >= candidates.length) return ;
        if(target < 0) return;
        if(candidates[from] > target) return;
        if(target == 0){
            result.add(new ArrayList<Integer>(cache));
            return;
        }

        for(int i = from; i < candidates.length;i++){
            if(i> from && candidates[i-1] == candidates[i]) continue;
            if(candidates[i] > target){
                return;
            }else if(candidates[i]== target){
                cache.add(candidates[i]);
                result.add(new ArrayList<Integer>(cache));
                cache.remove(cache.size()-1);
                return;
            }else{
                cache.add(candidates[i]);
                combinationSum2(candidates,i+1,target-candidates[i]);
                cache.remove(cache.size()-1);
            }
        }
    }
}