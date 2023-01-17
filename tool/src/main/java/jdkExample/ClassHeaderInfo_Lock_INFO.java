package jdkExample;

import org.openjdk.jol.info.ClassLayout;

public class ClassHeaderInfo_Lock_INFO {
    static class MarkWord{
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        MarkWord markWord = new MarkWord();
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());
        synchronized (markWord){
            System.out.println("lock1");
            System.out.println(ClassLayout.parseInstance(markWord).toPrintable());
        }
        System.out.println("lock1 over");
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (markWord){
                    System.out.println("lock2");
                    System.out.println(ClassLayout.parseInstance(markWord).toPrintable());
                }
            }
        }).start();

        Thread.sleep(5000);
        System.out.println("lock2 over");
        System.out.println(ClassLayout.parseInstance(markWord).toPrintable());

        Thread.sleep(500000);
    }
}
