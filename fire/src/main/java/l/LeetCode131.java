package l;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    public static void main(String[] args) {
        System.out.println("keep Happy boy");

    }

    /**
     *
     131. Palindrome Partitioning

     Given a string s, partition s such that every substring of the partition is a palindrome.
     Return all possible palindrome partitioning of s.

     A palindrome string is a string that reads the same backward as forward.

     Example 1:
     Input: s = "aab"
     Output: [["a","a","b"],["aa","b"]]
     Example 2:

     Input: s = "a"
     Output: [["a"]]


     Constraints:

     1 <= s.length <= 16
     s contains only lowercase English letters.

     * */

    public List<List<String>> partition(String s) {
        // Backtracking
        // Edge case
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    public void helper(String s, List<String> step, List<List<String>> result) {
        // Base case
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if (!isPalindrome(temp))
                continue; // only do backtracking when current string is palindrome

            step.add(temp); // choose
            helper(s.substring(i, s.length()), step, result); // explore
            step.remove(step.size() - 1); // unchoose
        }
        return;
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
