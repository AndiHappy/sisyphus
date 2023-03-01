package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode131_2 {


    class Solution {

        ArrayList<List<String>> ans;

        boolean check(String s, int l, int r) {
            while (l <= r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
            return true;
        }


        void dfs(ArrayList<ArrayList<String>> g, ArrayList<String> path, int cur, int n) {
            if (cur == n) {
                ans.add(new ArrayList<>(path));
            } else {
                for (int i = 0; i < g.get(cur).size(); i++) {
                    path.add(g.get(cur).get(i));
                    dfs(g, path, cur + g.get(cur).get(i).length(), n);
                    path.remove(path.size() - 1);
                }
            }
        }



        public List<List<String>> partition(String s) {
            int n = s.length();
            ArrayList<ArrayList<String>> g = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                g.add(new ArrayList<String>());
                for (int j = i; j < n; j++) {
                    if (check(s, i, j)) {
                        g.get(i).add(s.substring(i, j + 1));
                    }
                }
            }

            ans = new ArrayList<>();
            ArrayList<String> path = new ArrayList<>();
            dfs(g, path, 0, n);

            return ans;
        }
    }
}
