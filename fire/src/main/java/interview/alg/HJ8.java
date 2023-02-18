package interview.alg;

import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {


    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                String sum = in.nextLine();
                TreeMap<Integer, Integer> store = new TreeMap<Integer, Integer>();
                while (in.hasNextLine()) {
                    String[] tmp = in.nextLine().split(" ");
                    int key = Integer.parseInt(tmp[0]);
                    int value = Integer.parseInt(tmp[1]);
                    if (store.containsKey(key)) {
                        store.put(key, store.get(key) + value);
                    } else {
                        store.put(key, value);
                    }
                }

                for (Integer i : store.navigableKeySet()) {
                    System.out.println(i + " " + store.get(i));
                }
            }
        }
    }
}
