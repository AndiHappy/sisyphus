package l;

public class LeetCode059 {

    public int lengthOfLastWord(String s) {
        int lettersCount = 0;
        String sFiltered = s.trim();
        for(int i = sFiltered.length()-1; i >= 0; i--) {
            if(sFiltered.charAt(i) == ' ') {
                break;
            }

            lettersCount++;
        }
        return lettersCount;
    }
}
