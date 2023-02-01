package jucExample;

public class JUCExample {
    static final int HASH_BITS = 0x7fffffff;
    public static void main(String[] args) {
        System.out.println(HASH_BITS);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        for (long i = HASH_BITS ; i < Long.MAX_VALUE; i++) {
            System.out.println(i);
            System.out.println(i & HASH_BITS);
        }

    }
}
