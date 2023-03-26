package interview.alg;

import java.util.Scanner;

public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String slint = in.nextLine();
            char[] array = slint.toCharArray();

            if (array.length > 8) {
                int a = 0, b=0, d=0, e=0; boolean err = true;
                for (int i = 0; i < array.length; i++) {
                    char c = array[i];
                    // 数字
                    if (c >= '0' && c <= '9') {
                        a = 1;
                    } else if (c >= 'a' && c <= 'z') {
                        b = 1;
                    } else if (c >= 'A' && c <= 'Z') {
                        d = 1;
                    } else if (c == ' ' || c == '\n') {
                        //存在空格或换行
                        err = false;
                        break;
                    } else {
                        e = 1;
                    }
                }
                if (err) {
                    if ((a + b + d + e) >= 3) {
                        if (reStr(slint)) {
                            System.out.println("OK");
                        } else {
                            // 重复字符串
                            System.out.println("NG");
                        }
                    } else {
                        // 字符种类小于三种
                        System.out.println("NG");
                    }
                } else {
                    //存在空格
                    System.out.println("NG");
                }

            } else {
                //长度小于 8
                System.out.println("NG");
            }
        }
    }

    private static boolean reStr(String s) {
        for (int i = 3; i < s.length(); i++) {
            if (s.substring(i).contains(s.substring(i - 3, i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRepeat(String str){
        for(int i = 0; i < str.length()-2;i++){
            String childStr = str.substring(i,i+3);
            // 是否包含重复的子串
            if(str.substring(i+3).contains(childStr)){
                return false;
            }
        }
        return true;
    }
}
