package accumulate.backtracking;

import java.util.*;

public class L17 {

    /*
    回溯算法的伪代码：
    procedure backtrack(c) is
            if reject(P, c) then return
            if accept(P, c) then output(P, c)
            s ← first(P, c)
            while s ≠ NULL do
                backtrack(s)
                s ← next(P, s)
       */

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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCombinations("23").toArray()));
    }

    public static List<String> letterCombinations(String digits) {
//        s ← first(P, c)
        int firstIndex = 0;
        List<String> result = new ArrayList<String>();
        return backtrack(digits,firstIndex,result);
    }

    private static List<String> backtrack(String digits, int index, List<String> result) {
//        if reject(P, c) then return
//        if accept(P, c) then output(P, c)
//        s ← first(P, c)
//        while s ≠ NULL do
//            backtrack(s)
//        s ← next(P, s)
        if(index >= digits.length()) return result;
        char indexChar = digits.charAt(index);
        result = dealWith(result,indexChar);
        result = backtrack(digits,index+1,result);
        return result;
    }

    private static ArrayList<String> dealWith(List<String> result, char indexChar) {
        String match = letterMatch.getOrDefault(indexChar-'0',"");
        ArrayList<String> addRes = new ArrayList<>();
        for (int i = 0; i < match.length(); i++) {
            StringBuilder tmpRes = new StringBuilder();
            tmpRes.append(match.charAt(i));
            if(result.size() == 0) {
                addRes.add(tmpRes.toString());
            }else{
                for (int j = 0; j < result.size(); j++) {
                    addRes.add(result.get(j)+tmpRes.toString());
                }
            }
        }
        return addRes;
    }

}
