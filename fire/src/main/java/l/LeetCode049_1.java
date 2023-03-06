package l;

import java.util.*;

public class LeetCode049_1 {

    //Given an array of strings strs, group the anagrams together. You can return th
//e answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once.
//
//
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
// Input: strs = [""]
//Output: [[""]]
// Example 3:
// Input: strs = ["a"]
//Output: [["a"]]
//
//
// Constraints:
//
//
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lower-case English letters.
//
// Related Topics Hash Table String

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        List<List<String>> result = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List a :
                result) {
            System.out.println(a.toString());
            System.out.println("------------------");
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> str = map.getOrDefault(key,new ArrayList<>());
            str.add(strs[i]);
            map.put(key,str);
        }
        return  new ArrayList<>(map.values());
    }


    public List<List<String>> groupAnagrams_2(String[] strs) {
            Map<String ,List<String>> map = new HashMap<>();
            for (String str: strs){
                int[] counts = new int[26];
                for (char c : str.toCharArray()) counts[c-'a']++;
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if(counts[i] != 0){
                        builder.append((char)('a'+i));
                        builder.append(counts[i]);
                    }
                }
                String key = builder.toString();
                List<String> list = map.getOrDefault(key,new ArrayList<>());
                list.add(str);
                map.put(key,list);
            }
            return  new ArrayList<>(map.values());
    }



}
