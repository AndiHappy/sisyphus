package jucExample;

/**
 * increase字节码：
 * public static void increase();
 * Code:
 * Stack=2, Locals=0, Args_size=0
 * 0: getstatic
 * 3: iconst_1
 * 4: iadd
 * 5: putstatic
 * 8: return
 * LineNumberTable: line 14: 0 line 15: 8
 *
 * */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}
