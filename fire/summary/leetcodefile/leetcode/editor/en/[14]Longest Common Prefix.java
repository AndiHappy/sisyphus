//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics String 
// 👍 5730 👎 2543


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 <= strs.length <= 200
    // 0 <= strs[i].length <= 200
    // strs[i] consists of only lower-case English letters.
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String tmp = strs[0];int i = 0;
        for (; i < tmp.length(); i++) {
            if(!math_j_th_character(strs,tmp.charAt(i),i)) break;
        }
        return tmp.substring(0,i);
    }

    public static boolean math_j_th_character(String[] strs, char tmp,int index){
        for (int i = 1; i <strs.length; i++) {
            if(index >= strs[i].length() || strs[i].charAt(index) != tmp) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
