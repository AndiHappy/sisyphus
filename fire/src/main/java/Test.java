
import java.util.*;

import util.ListNode;
import util.Parenthesees;
import util.TreeNode;

public class Test {

    /**
     * 95. Unique Binary Search Trees II
     * **/


    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String tmp = strs[0];int i = 0;
        for (; i < tmp.length(); i++) {
            boolean math = math_j_th_character(strs,tmp.charAt(i),i);
            if(!math)break;
        }
        return tmp.substring(0,i);
    }

    public static boolean math_j_th_character(String[] strs, char tmp,int index){
        boolean result = true;
        for (int i = 1; i <strs.length; i++) {
            result = result && index < strs[i].length() && strs[i].charAt(index) == tmp;
            if(!result) break;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println( longestCommonPrefix((String[]) Arrays.asList("flower","flow","flight").toArray()));

        System.out.println( longestCommonPrefix((String[]) Arrays.asList("dog","d").toArray()));

    }

}
