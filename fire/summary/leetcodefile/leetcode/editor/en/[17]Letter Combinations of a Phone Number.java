//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 
// 👍 8858 👎 628


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static Map<Integer,String> letterMatch = new HashMap<>();
    static {
        letterMatch.put(2,"abc");
        letterMatch.put(3,"def");
        letterMatch.put(4,"ghi");
        letterMatch.put(5,"jkl");
        letterMatch.put(6,"mno");
        letterMatch.put(7,"pqrs");
        letterMatch.put(8,"tuv");
        letterMatch.put(7,"wxyz");

    }


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String match = letterMatch.getOrDefault(digits.charAt(i)-'0',"");
            result = dealMatch(match,result);
//            System.out.println(Arrays.toString(result.toArray()));
        }
        return result;
    }

    private static List<String> dealMatch(String match, List<String> result) {
        List<String> addRes = new ArrayList<>();
        for (int i = 0; i < match.length(); i++) {
            StringBuilder tmpRes = new StringBuilder();
            tmpRes.append(match.charAt(i));
            if(result.size() == 0) {
                addRes.add(tmpRes.toString());
            }else{
                for (int j = 0; j < result.size(); j++) {
                    addRes.add(tmpRes.toString()+result.get(j));
                }
            }
        }
        return addRes;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
