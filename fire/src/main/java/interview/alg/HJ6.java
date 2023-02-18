package interview.alg;
import java.util.Scanner;

public class HJ6 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                int a = in.nextInt();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 2; i * i <= a; i++) {
                    if (a % i == 0) {
                        stringBuilder.append(i).append(" ");
                        a = a / i;
                        i--;
                    }

                }
                stringBuilder.append(a).append(" ");
                System.out.println(stringBuilder.toString());

            }
        }
    }
}
