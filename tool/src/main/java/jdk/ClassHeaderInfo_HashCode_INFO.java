package jdk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class ClassHeaderInfo_HashCode_INFO {
    static class MarkWord{
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("before hash");
        MarkWord markWord = new MarkWord();
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());
        int hashcode = System.identityHashCode(markWord);
        String binaryString =  Integer.toBinaryString(hashcode);
        System.out.println("The identity hash code BinaryString is " + binaryString);
        // 因为JVM 以小端格式存储数值，所以：按照8位(一个字节)翻转hashcode的二进制，转化为16进制
        int i = binaryString.length();
        for (; i >=0; i-=8) {
            String sub =  binaryString.substring(i-8>=0?i-8:0,i);
            String hexString =  Integer.toHexString(Integer.parseInt(sub,2));
            if(hexString.length() == 1){ hexString="0"+hexString;}
            System.out.print(hexString+ " ");
        }
        System.out.println();
        System.out.println("------------------------after hash------------------------");
        //计算hashcode之后的对象头
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());
    }
}
