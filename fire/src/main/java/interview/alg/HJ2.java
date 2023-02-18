package interview.alg;

import java.util.HashMap;
import java.util.Scanner;

public class HJ2 {
    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            String key = in.nextLine();
            HashMap<String, Integer> cal = new HashMap<String, Integer>();
            for (int i = 0; i < line.length(); i++) {
                String tmp = String.valueOf(line.charAt(i)).toLowerCase();
                cal.put(tmp, cal.getOrDefault(tmp, 0) + 1);
            }

            System.out.println(cal.getOrDefault(key.toLowerCase(), 0));
        }
    }
}
