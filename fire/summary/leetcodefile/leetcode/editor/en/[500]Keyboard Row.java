//Given an array of strings words, return the words that can be typed using lett
//ers of the alphabet on only one row of American keyboard like the image below. 
//
// In the American keyboard: 
//
// 
// the first row consists of the characters "qwertyuiop", 
// the second row consists of the characters "asdfghjkl", and 
// the third row consists of the characters "zxcvbnm". 
// 
//
// 
// Example 1: 
//
// 
//Input: words = ["Hello","Alaska","Dad","Peace"]
//Output: ["Alaska","Dad"]
// 
//
// Example 2: 
//
// 
//Input: words = ["omk"]
//Output: []
// 
//
// Example 3: 
//
// 
//Input: words = ["adsdf","sfd"]
//Output: ["adsdf","sfd"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] consists of English letters (both lowercase and uppercase). 
// 
// Related Topics Array Hash Table String 
// 👍 819 👎 860


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static HashSet<Character> first= new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p')) ;
    private static HashSet<Character> second = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l')) ;
    private static HashSet<Character> third = new HashSet<>(Arrays.asList('z','x','c','v','b','m','n')) ;

    public String[] findWords(String[] a) {
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
        s=s.toLowerCase();
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
//leetcode submit region end(Prohibit modification and deletion)
