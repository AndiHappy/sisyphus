package accumulate.iteration_control;

public class L14 {

    /**
     * first: describe the problem
     *
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lower-case English letters.
     * second: use iteration
     * third: write the code
     * fourth: test the case
     *
     * */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String base = strs[0];int index=0;
        boolean continueFlag=true;
        for (; continueFlag && index < base.length() ; index++) {
            for (int i = 1; i < strs.length; i++) {
                String compare = strs[i];
                if (compare.charAt(index) != base.charAt(index)){
                    continueFlag=false;
                    break;
                }
            }
            if(!continueFlag) break;
        }
        return base.substring(0,index);

    }

    public static String longestCommonPrefix_2(String[] strs) {
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

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aaa","cccc"}));
        System.out.println(longestCommonPrefix_2(new String[]{"aaa","cccc"}));
    }

}
