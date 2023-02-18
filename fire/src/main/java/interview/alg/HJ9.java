package interview.alg;

import java.util.HashSet;
import java.util.Scanner;

public class HJ9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            HashSet<Integer> cache = new HashSet<Integer>();
            int result = 0;
            while(a > 0){
                int tmp = a%10;
                if(!cache.contains(tmp)){
                    cache.add(tmp);
                    result=result*10+tmp;
                }
                a=a/10;
            }
            System.out.println(result);
        }
    }
}
