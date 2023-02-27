package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private static final HashMap<Character,String> num2String = new HashMap<>();
    static{
        num2String.put('1',"");
        num2String.put('2',"abc");
        num2String.put('3',"def");
        num2String.put('4',"ghi");
        num2String.put('5',"jkl");
        num2String.put('6',"mno");
        num2String.put('7',"pqrs");
        num2String.put('8',"tuv");
        num2String.put('9',"wxyz");
    }

    private static ArrayList<String> v = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        v.clear();
        if(digits == null || digits.length() == 0) return new ArrayList<>();   
        letterCombinations(digits,0, v);
        return v;
    }

    public void letterCombinations(String digits,int from,ArrayList<String> result){
        if(from >= digits.length()) return;
        char di = digits.charAt(from);
        String diS = num2String.get(di);
        ArrayList<String> newList = new ArrayList<String>();
        for(int j= 0;j < diS.length();j++){
            char disj = diS.charAt(j);
            if(from == 0){
                newList.add(String.valueOf(disj));
            }else{
                for(int k =0 ;k < result.size(); k++){
                    newList.add(result.get(k)+disj);
                }
            }
        }
        this.v = newList;
        letterCombinations(digits,from+1,this.v);
        System.out.println(Arrays.toString(this.v.toArray()));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.letterCombinations("23").toArray()));
    }

}