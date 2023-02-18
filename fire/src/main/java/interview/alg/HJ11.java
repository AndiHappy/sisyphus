package interview.alg;

import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
           String line = in.nextLine();
           StringBuilder builder = new StringBuilder(line);
           System.out.println(builder.reverse().toString());
            System.out.println(reverse(line));
        }
    }

    public static String reverse(String line){
        char[] v = line.toCharArray();
        for (int i = 0,j=v.length-1; i <j ; i++,j--) {
            char t = v[i];
            v[i] = v[j];
            v[j] = t;
        }
        return new String(v);
    }
}
