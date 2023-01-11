package jdk;

import org.openjdk.jol.info.ClassLayout;

public class MyHashMap {

    static class Example{

    }
    public static void main(String[] args) {
        Example example = new Example();

        System.out.println(ClassLayout.parseInstance(example).toPrintable());

        System.out.println(System.currentTimeMillis());
    }
}
