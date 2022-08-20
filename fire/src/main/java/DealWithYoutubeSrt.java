import com.sun.deploy.util.StringUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class DealWithYoutubeSrt {
    /***
     *
     * 处理 YouTube 的字幕
     * 消除字幕中的数字，时间标识
     * */

    public static void main(String[] args) throws IOException {
        String filtPath = "/Users/zhailzh/project/github/2021/algorithm/src/main/java/HtSuA80QTyo.srt";
        Reader input  = new FileReader(filtPath);

        String filtPathWrite = "/Users/zhailzh/project/github/2021/algorithm/src/main/java/HtSuA80QTyo.txt";
        Writer writer = new FileWriter(filtPathWrite);

        List<String>  result =  IOUtils.readLines(input);

        StringBuilder linedeal = new StringBuilder();

        int nums = 1;
        for (int i = 0; i < result.size(); i++) {
            String line = result.get(i).trim();
            if(line.equals(String.valueOf(nums))){
                nums++;
                continue;
            }
            if(line.startsWith("00") || line.equals("") || line.equals(" ")){
                continue;
            }else{
                if(line.startsWith("-")){
                    linedeal.append(line);
                }else{
                    linedeal.append(" "+ line);
                }

                if(line.endsWith(",") || line.endsWith(".") || line.endsWith("]") || line.endsWith(";")){
                    IOUtils.write("\n",writer);
                    IOUtils.write(linedeal.toString(),writer);
                    IOUtils.write("\n",writer);
                    linedeal = new StringBuilder();
                }

            }
        }


    }
}
