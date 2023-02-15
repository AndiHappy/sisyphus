package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Info {
    //主要说明输入输出的格式问题

    public static void main(String[] args) throws IOException {

        // 获取输入的某一行的数据，例如：hello nowcoder
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String line2 = in.nextLine();

        //获取输入的空格隔开的数字，例如：1 5 6 7
        while(in.hasNext()){
            int a = in.nextInt();
            int b = in.nextInt();
        }

        //读取到的是一个int，转化为char
        InputStream inputStream = System.in;
        char c;
        while('\n' != (c = (char) inputStream.read())){
            System.out.println(c);
        }

        //包装出来BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String lineContent1 = bufferedReader.readLine();
        String lineContent2 = bufferedReader.readLine();

        //Reads the next byte of data from the input stream.
        // The value byte is returned as an int in the range 0 to 255.
        // If no byte is available because the end of the stream has been reached,
        // the value -1 is returned.
        int intvalue=0;
        while(-1 != ( intvalue = inputStream.read())){
            System.out.println(c);
        }




    }
}
