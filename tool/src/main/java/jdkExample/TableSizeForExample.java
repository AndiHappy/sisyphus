package jdkExample;

public class TableSizeForExample {
    public static void main(String[] args) {
        for (int i = 17; i < 523; i++) {
            System.out.println(Integer.numberOfLeadingZeros(i - 1));
            int n = -1 >>> Integer.numberOfLeadingZeros(i - 1);
            System.out.println(n);
        }
    }
}
