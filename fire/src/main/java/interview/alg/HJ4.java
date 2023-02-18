package interview.alg;
import java.util.Scanner;

public class HJ4 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line == null || line.startsWith(" ")) continue;
                StringBuilder builer = new StringBuilder();
                int i = 0;
                while (i * 8 < line.length()) {
                    for (int j = i * 8; j < (i + 1) * 8; j++) {
                        char chacteri = j < line.length() ? line.charAt(j) : '0';
                        builer.append(chacteri);
                    }
                    System.out.println(builer.toString());
                    i = i + 1;
                    builer = new StringBuilder();
                }
            }

        }
    }
}
