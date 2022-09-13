import org.apache.commons.io.IOUtils;
import util.ListNode;

import java.io.*;
import java.util.List;

public class DealWithYoutubeLeetcodeSrt {

    public ListNode mergeKLists_iterator(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,int from,int to){
        if(from == to) return lists[from];
        if(from < to){
            int mid = (from+to)/2;
            return  merge(mergeKLists(lists,from,mid),
                    mergeKLists(lists,mid+1,to))	;
        }
        return null;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val > l2.val){
            l2.next=merge(l1,l2.next);
            return l2;
        } else{
            l1.next=merge(l1.next,l2);
            return l1;
        }

    }

    /***
     *
     * 处理 YouTube 的字幕
     * 消除字幕中的数字，时间标识
     * */

    public static void main(String[] args) throws IOException {
        String filtPath = "/Users/zhailzh/project/github/2021/algorithm/src/main/java/twosum.srt";
        Reader input = new FileReader(filtPath);

        String filtPathWrite = "/Users/zhailzh/project/github/2021/algorithm/src/main/java/twosum.txt";
        Writer writer = new FileWriter(filtPathWrite);

        List<String> result = IOUtils.readLines(input);

        StringBuilder linedeal = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            String line = result.get(i);
            if(line == null || line.length() ==0 || line.startsWith(" ") || Character.isDigit(line.charAt(0))
                    || (line.length() > 1 && Character.isDigit(line.charAt(0)) && Character.isDigit(line.charAt(1))) ) {
                continue;
            }

            if (line.startsWith("-")) {
                linedeal.append(line);
            } else {
                linedeal.append(" " + line);
            }

            System.out.println(linedeal.toString());

//            if (line.endsWith(",") || line.endsWith(".") || line.endsWith("]") || line.endsWith(";")) {
//                IOUtils.write("\n", writer);
//                IOUtils.write(linedeal.toString(), writer);
//                IOUtils.write("\n", writer);
//                linedeal = new StringBuilder();
//            }

        }

}

    private static String update(String nums) {
        Integer nu = Integer.parseInt(nums);
        return String.valueOf(nu + 1);
    }
}
