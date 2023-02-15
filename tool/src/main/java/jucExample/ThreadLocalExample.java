package jucExample;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample {

    private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

    private static ThreadLocal<Object> inheritableThreadLocal = new InheritableThreadLocal<Object>();

    private static AtomicInteger v = new AtomicInteger(0);

    public static void main(String[] args) {
//        testThreadLocal();
        inheritableThreadLocal.set("parent");
        Thread child = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(inheritableThreadLocal.get());
                inheritableThreadLocal.set("child");
            }
        });
        child.start();
        while (Thread.activeCount() > 1) Thread.yield();
        System.out.println(inheritableThreadLocal.get());
    }

    private static void testThreadLocal() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set(v.incrementAndGet());
                    System.out.println(Thread.currentThread().getName());
                    while(true){
                        try {
                            Thread.sleep(100000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            threads[i].start();
        }
    }
}
