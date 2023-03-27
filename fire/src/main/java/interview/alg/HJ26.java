package interview.alg;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 * 数据范围：输入的字符串长度满足
 * 1
 * ≤
 * �
 * ≤
 * 1000
 *
 * 1≤n≤1000
 *
 * 输入描述：
 * 输入字符串
 * 输出描述：
 * 输出字符串
 * 示例1
 * 输入：
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 复制
 * 输出：
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 * */
public class HJ26 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                String line = in.nextLine();
                line = sort(line);
                System.out.println(line);
            }
        }

        public static String sort(String line) {
            // 先将英文字母收集起来
            List<Character> letters = new ArrayList<Character>();
            for (char ch : line.toCharArray()) {
                if (Character.isLetter(ch)) {
                    letters.add(ch);
                }
            }

            //将字母排序
            letters.sort(new Comparator<Character>() {
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }

            });

            //非英文的字符直接的添加
            StringBuilder result = new StringBuilder();
            for(int i=0,j=0;i<line.length();i++){
                if(Character.isLetter(line.charAt(i))){
                    result.append(letters.get(j++));
                }else{
                    result.append(line.charAt(i));
                }
            }

            return result.toString();
        }
    }
}
