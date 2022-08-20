import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class DealWithYoutubeLeetcodeSrt {
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
