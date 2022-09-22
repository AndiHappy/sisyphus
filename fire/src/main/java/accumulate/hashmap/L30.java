package accumulate.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L30 {
    private int k;//数组的长度
    private int wordLength;
    private int substringSize;

    private Map<String ,Integer> wordCount = new HashMap<>();

    /**
     * 字符串的匹配的算法
     * */
    public List<Integer> findSubstring(String s, String[] words){
        // 全部都在初始化
        int n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength*k;
        for (String word:words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n - substringSize + 1; i++) {
            if(check(i,s)){
                answer.add(i);
            }
        }
        return answer;
    }

    //判断从字符串S的index为i的位置，开始是否有完全匹配的字符串
    private boolean check(int i, String s) {
        //每次相当于从words的数组中复制一个
        HashMap<String , Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed =0;
        //每次都是拆分subString，也就是wordLength的步长进行比对,匹配的范围是：整个匹配的字符串长度（i+substringSize）
        for (int j = i; j < i+substringSize ; j+= wordLength) {
            String subString = s.substring(j,j+wordLength);
            if(remaining.containsKey(subString)){
                remaining.put(subString,remaining.get(subString)-1);
                wordsUsed++;
            }else{
                break;
            }
        }

        return wordsUsed == k;
    }
}
