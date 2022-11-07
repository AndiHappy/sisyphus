package jdkexampl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalExample {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    static ThreadLocal<Integer> InhertThreadLocal = new InheritableThreadLocal<>();
    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        test_mainThread_childThread_set_get();
        test_mainThread_childThread_set_get_Inheritable();

    }

    private static void test_mainThread_childThread_set_get_Inheritable() throws InterruptedException {
        System.out.println("主线程开启");
        InhertThreadLocal.set(1);
        System.out.println("主线程读取本地变量：" + InhertThreadLocal.get());

        executorService.submit(() -> {
            System.out.println("子线程读取本地变量：" + InhertThreadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);

        InhertThreadLocal.set(2);
        System.out.println("主线程读取本地变量：" + InhertThreadLocal.get());

        executorService.submit(() -> {
            //[没有读到了主线程修改后的新值]
            System.out.println("子线程读取本地变量：" + InhertThreadLocal.get());
            InhertThreadLocal.set(3);
            System.out.println("子线程读取本地变量：" + InhertThreadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);
        //依旧读取的是2
        System.out.println("主线程读取本地变量：" + InhertThreadLocal.get());
    }



    private static void test_mainThread_childThread_set_get() throws InterruptedException {
        System.out.println("主线程开启");
        threadLocal.set(1);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程读取本地变量：" + threadLocal.get());
            }
        });

        TimeUnit.SECONDS.sleep(1);

        threadLocal.set(2);
        System.out.println("主线程读取本地变量：" + threadLocal.get());

        executorService.submit(() -> {
            //[没有读到了主线程修改后的新值]
            System.out.println("子线程读取本地变量：" + threadLocal.get());
            threadLocal.set(3);
            System.out.println("子线程读取本地变量：" + threadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);
        //依旧读取的是2
        System.out.println("主线程读取本地变量：" + threadLocal.get());
    }
}
