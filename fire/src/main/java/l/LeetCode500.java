package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LeetCode500 {

    public static void main(String[] args) {
        System.out.println("keep happy！");
        String[] a = (String[]) Arrays.asList("asdfghjkl","qwertyuiop","zxcvbnm").toArray();
        String[] result = testArray(a);
        System.out.println(Arrays.toString(result));
    }

    private static HashSet<Character> first= new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p')) ;
    private static HashSet<Character> second = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l')) ;
    private static HashSet<Character> third = new HashSet<>(Arrays.asList('z','x','c','v','b','m','n')) ;

    private static String[] testArray(String[] a) {
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(checkString(a[i])) tmp.add(a[i]);
        }
        String[] result = new String[tmp.size()];
        tmp.toArray(result);
        return result;
    }

    private static boolean checkString(String s) {
        HashSet<Character> judge = null;
        char si = s.charAt(0);
        if(first.contains(si)) judge=first;
        if(second.contains(si)) judge=second;
        if(third.contains(si)) judge=third;

        for (int i = 1; i < s.length(); i++) {
            if(judge==null || !judge.contains(s.charAt(i))) return false;
        }
        return true;
    }

}
