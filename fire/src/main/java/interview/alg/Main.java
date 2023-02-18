package interview.alg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String lineContent = in.nextLine();
            int value = 0;

            if(lineContent.startsWith("0x")){
                for(int i =2;i<lineContent.length();i++){
                    char char16 = lineContent.charAt(i);
                    int char16int = 0;
                    if(char16>='0' && char16 <='9'){
                        char16int=char16-'0';
                    } else if(char16 >='A' && char16 <= 'F') {
                        char16int=10+char16-'A';
                    }
                    value = value *16 + char16int;
                }
                System.out.println(Integer.toHexString(value));
                System.out.println(value);
            }
        }
    }
}