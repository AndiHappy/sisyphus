package interview.alg;
import java.util.*;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String v = in.nextLine();
            String[] array = v.split(" ");
            int n = Integer.parseInt(array[0]);
            List<String> ss = new ArrayList<String>();
            for (int i = 1; i < array.length - 2; i++) {
                ss.add(array[i]);
            }

            String key = array[array.length - 2];
            int[] keyarray = new int[256];
            for (Character keyc : key.toCharArray()) {
                keyarray[keyc - 'a']++;
            }
            int num = Integer.parseInt(array[array.length - 1]);

            List<String> filters = filter(ss, key, keyarray);
            System.out.println(filters.size());
            if (filters.size() >= num) {
                System.out.print(filters.get(num - 1));
            }
        }
    }

    public static List<String> filter(List<String> ss, String key, int[] keyCache) {
        List<String>  result = new ArrayList<String>();
        for (int i = 0; i < ss.size(); i++) {
            String tmp = ss.get(i);
            if (judge(tmp, key, keyCache)) {
                result.add(tmp);
            }
        }

        //排序
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return result;
    }

    private static boolean judge(String tmp, String key, int[] keyCache) {
        if (tmp.length() < key.length() || tmp.length() > key.length()) {
            return false;
        } else {
            if (tmp.equals(key)) {
                return false;
            } else {
                int[] b = new int[256];
                for (char bc : tmp.toCharArray()) {
                    b[bc - 'a']++;
                }
                for (int i = 0; i < b.length; i++) {
                    if (b[i] != keyCache[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
