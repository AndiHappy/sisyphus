//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 26998 👎 1171

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() ==1 ) return 1;
        HashMap<Character,Integer> window = new HashMap<>(s.length());
        int from = 0;int result=0;
        for (int i = 0; i < s.length(); i++) {
            Character tmp = s.charAt(i);
            if(window.containsKey(tmp)){
                from = window.get(tmp) >= from ? window.get(tmp)+1:from;
            }
            window.put(tmp,i);
            result = Math.max(result,(i-from+1));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
