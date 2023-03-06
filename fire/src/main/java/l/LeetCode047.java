package l;

import java.util.*;

public class LeetCode047 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Set<Integer> set = new HashSet<Integer>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        n=nums.length;
        permuteUnique(nums,0);
        return result;
    }

    public void permuteUnique(int[] nums,int fromIndex){
        if(path.size() == n){
            result.add(new ArrayList<>(path));
        }

        for(int i =0;i < n;i++){
            if(i > fromIndex &&  nums[i-1]==nums[i]) continue;
//            if(!set.contains(i)){
//                set.add(i);
                path.add(nums[i]);
                permuteUnique(nums,fromIndex);
                path.remove(path.size()-1);
//                set.remove(i);
//            }

        }
    }

    public static void main(String[] args) {
        LeetCode047 test = new LeetCode047();
        List<List<Integer>> r = test.permuteUnique(new int[]{1,2,1});
        for(List l : r){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
