package jdkExample;

import java.io.IOException;
import java.io.InputStream;

public class RunTimeTest {
    public static void main(String[] args) throws IOException {
        String[] shell = new String[]{"/bin/sh","-c","ls -l > output.txt"};
        String[] env = new String[]{"prod"};
        Process Process = Runtime.getRuntime().exec(shell,env);
        InputStream stream = Process.getInputStream();
        byte[] all = stream.readAllBytes();
        System.out.println(new String(all));
    }
}
