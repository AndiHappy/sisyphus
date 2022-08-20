package accumulate.nomeet;

public class L06 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows)
            return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                builders[j].append(s.charAt(i));
                i++;
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                builders[j].append(s.charAt(i));
                i++;
            }
        }
        String res = "";
        for (int jj = 0; jj < numRows; jj++) {
            res += builders[jj].toString();
        }
        return res;
    }

}
