package accumulate.nomeet;

public class L13 {
    public int romanToInt(String S) {
        int ans = 0, num = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            switch(S.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            // key point is small or big two side value
            if (4 * num < ans){
                ans -= num;
            } else {
                ans += num;
            }
        }
        return ans;
    }
}
