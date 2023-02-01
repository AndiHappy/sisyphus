package jucExample;

public class StateExample {

    static final int WRITER = 1; // set while holding write lock
    static final int WAITER = 2; // set when waiting for write lock
    static final int READER = 4; // increment value for setting read lock

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString((WAITER|WRITER)));
        for (int i = 0; i < 10; i++) {
            System.out.println(i+ " : " +Integer.toBinaryString(i));
            int state = (i & (WAITER|WRITER));
            System.out.println(state+ " : " +Integer.toBinaryString(state));
        }
    }
}
