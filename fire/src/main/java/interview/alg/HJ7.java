package interview.alg;
import java.util.Scanner;

public class HJ7 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while(in.hasNextLine()){
                String line = in.nextLine();
                int index = line.indexOf(".");
                int a = Integer.parseInt(line.substring(0,index));
                int b = Integer.parseInt(line.substring(index+1,index+2));
                int result = b>=5?a+1:a;
                System.out.println(result);
            }
        }
    }
}
