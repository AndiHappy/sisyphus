package interview;

import java.util.Scanner;

public class Choose7 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
     static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                int max = in.nextInt();
                int result =  contain7(max);
                System.out.println(result);
            }
        }

        public static int contain7( int n) {
            int c7 = 0;
            for (int i = 1 ; i <=n; i++) {
                if ( i%7 ==0 || i % 10 == 7 || (i/10)%10 == 7 || (i/100)%10 == 7 || (i/1000)%10==7) {
                    c7++;
                }
            }
            return c7;
        }
    }
}
