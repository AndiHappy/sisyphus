package interview.alg;

import java.util.Scanner;

public class HJ17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String ins = in.nextLine();
            String[] array = ins.split(";");
            int x = 0;
            int y = 0;
            for (String s : array) {
                int v = 0;
                if ("".equals(s) || s.length() > 3) continue;
                // A10,AA0
                for (int i = 1; i < s.length(); i++) {
                    int t = s.charAt(i) - '0';
                    if (t >= 0 && t <= 9) {
                        if (i == 1 && s.length() != 2) v += t * 10;
                        else v += t;
                    } else {
                        v = 0;
                        break;
                    }
                }
                char c = s.charAt(0);
                switch (c) {
                    case 'A':
                        x -= v;
                        break;
                    case 'D':
                        x += v;
                        break;
                    case 'W':
                        y += v;
                        break;
                    case 'S':
                        y -= v;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(x + ","+ y);
        }
    }
}
