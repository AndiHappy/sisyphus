package jucExample;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ThreadLocalRandom 类维护了一个类单例字段，线程通过调用 ThreadLocalRandom#current() 方法来获取 ThreadLocalRandom 单例，
 * 然后以线程维护的实例字段 threadLocalRandomSeed 为种子生成下一个随机数和下一个种子值。
 * 那么既然是单例模式，为什么多线程共用主线程初始化的实例就会出问题呢。
 * 问题就在于 current 方法，线程在调用 current() 方法的时候，
 * 会根据用 <b> 每个线程的 thread 的一个实例字段 threadLocalRandomProbe 是否为 0 来判断是否当前线程实例是否为第一次调用随机数生成方法 </b>
 * 从而决定是否要给当前线程初始化一个随机的 threadLocalRandomSeed 种子值。
 * 因此，如果其他线程绕过 current 方法直接调用随机数方法，
 * 那么它的种子值就是 0, 1*gamma, 2*gamma... 因此也就是可预测的了。
 *
 * */
public class ThreadLocalRandomDemo {
 
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Player().start();
        }
    }
 
    private static class Player extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + ": " + ThreadLocalRandom.current().nextInt(100));
        }
    }
}