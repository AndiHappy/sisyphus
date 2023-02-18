package interview.alg;

import java.util.HashMap;

public class Interview {

    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    //input: s is null,
    //output: 不含有重复字符, 最长子串，int
    //confirm：slid window 方式实现
    public static int findLongestNoSameSubString(String s){
        //处理特殊情况
        if(s == null) return 0;
        if(s.length() <=1 ) return  s.length();
        int result =1; int fromIndex=0;
        HashMap<Character,Integer> window = new HashMap<>();
        //滑动窗口控制,起始fromindex，结束就是i
        for (int i = 1; i < s.length(); i++) {
            if(window.containsKey(s.charAt(i))){
                fromIndex = Math.max(fromIndex,window.get(s.charAt(i))+1);
            }
            window.put(s.charAt(i),i);
            result = Math.max(result,i-fromIndex+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abdba";
        System.out.println(findLongestNoSameSubString(s));
    }
}
