package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode131_1 {


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

    /**
     131. 分割回文串
     给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

     回文串 是正着读和反着读都一样的字符串。



     示例 1：

     输入：s = "aab"
     输出：[["a","a","b"],["aa","b"]]
     示例 2：

     输入：s = "a"
     输出：[["a"]]


     提示：

     1 <= s.length <= 16
     s 仅由小写英文字母组成

     * */

    /**
     * 暴力破解的方式：对于字符串 s，如果一个一个的分割，都是回文字符串，如果二个二个的分割，就涉及到从哪里开始分割了
     *  这个时候，就需要两层循环，三个三个的分割，就需要三层循环来进行判断，所以这种走回溯算法来的
     *
     *  这个切割的方法和组合的选择的，可以统一在一起来进行说明

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

     * */
    public List<List<String>> partition_b(String s) {
        List<List<String>> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        partition(s,0,result,stack);
        return result;
    }

    private void partition(String s, int startIdex, List<List<String>> result, Stack<String> stack) {
        if(startIdex >= s.length()){
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int j = startIdex; j < s.length(); j++) {
            if(isPalindrome(s,startIdex,j)){
                stack.push(s.substring(startIdex,j+1));
            }else{
                continue;
            }
            partition(s,startIdex+1,result,stack);
            stack.pop();
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        LeetCode131_1 test = new LeetCode131_1();
        List<List<String>> r = test.partition("aabcddc");
        for (List l :r){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
}
