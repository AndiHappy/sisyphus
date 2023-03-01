package l;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131_3 {
    class Solution {


        int[][] ispArray = null;
        List<List<String>>  result = new ArrayList<>();
        //对于这个 add，remove 的算法，ArrayList 的 remove(int index) 比 LinkedList 的remove(int index)  要快
        List<String> cache = new ArrayList<String>();
        int n;
        public List<List<String>> partition(String s) {
            n=s.length();
            ispArray = new int[n][n];
            partition(s,0);
            return result;
        }

        public int isPalindrome(String s, int i, int j){
            if (ispArray[i][j] != 0) {
                return ispArray[i][j];
            }
            if (i >= j) {
                ispArray[i][j] = 1;
            } else if (s.charAt(i) == s.charAt(j)) {
                ispArray[i][j] = isPalindrome(s, i + 1, j - 1);
            } else {
                ispArray[i][j] = -1;
            }
            return ispArray[i][j];
        }

        public void partition(String s,int fromIndex){
            if(fromIndex >= n){
                result.add(new ArrayList<>(cache));
                return;
            }

            for(int i= fromIndex;i<n;i++){
                if(isPalindrome(s, fromIndex, i) == 1){
                    cache.add(s.substring(fromIndex,i+1));
                    partition(s,i+1);
                    cache.remove(cache.size()-1);
                }
            }
        }
    }
}
