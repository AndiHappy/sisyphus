package jucExample;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class MyAtomicInteger {
    public int value = 0;

    public int value2=0;

    public VarHandle varHandle;


    public MyAtomicInteger(int value) throws NoSuchFieldException, IllegalAccessException {
        this.value=value;
        this.value2=value;
        Class<?> class1 = MyAtomicInteger.class;
        this.varHandle = MethodHandles.lookup().findVarHandle(class1,"value2", int.class);
    }


    public void increment(){
        this.value++;
    }

    public void atomicIncrement(){
        while (true){
            if(!varHandle.compareAndSet(this,this.value2,this.value2+1)){
                System.out.println("race faild");
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MyAtomicInteger myAtomicInteger =new  MyAtomicInteger(0);

        Thread[] threads = new Thread[1000];
        for (int i =0;i<1000;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        myAtomicInteger.increment();
                        myAtomicInteger.atomicIncrement();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) Thread.yield();
        System.out.println(myAtomicInteger.value);
        System.out.println(myAtomicInteger.value2);
    }
}
