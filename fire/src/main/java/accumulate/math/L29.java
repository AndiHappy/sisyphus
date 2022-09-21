package accumulate.math;

public class L29 {

    public static void main(String[] args) {
        divide(-589, -3);
    }


    public static int divide(int dividend, int divisor) {
        /***
         * 首先jdk中定义int占4个字节 => 32位
         * 32位就是jvm仅仅给分配32个格子的空间，用以存放数据。
         * java中int有正负之分。所以32个格子中占用一个格子标识正负。java 使用补码标识数字
         * 正数的原码，反码，补码全部一样，负数的补码是在原码的基础上，符号位不变，其余各位取反,最后+1
         * 所以仅仅能用31个格子来标识数值。标识位：0标识正 1来标识负。
         * */
//        System.out.println(-1 << 31);
//        System.out.println((1 << 31) - 1);

        /**
         * A constant holding the maximum value an {@code int} can have, 2<sup>31</sup>-1.
         */
//        int maxNum = Integer.MAX_VALUE;
        /**
         * A constant holding the minimum value an {@code int} can have, -2<sup>31</sup>.
         */
//        int minNum = Integer.MIN_VALUE;
//        System.out.println(maxNum);
//        System.out.println(minNum);

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // 修改传入的参数必须为负值
        if(dividend > 0 && divisor > 0){
            return divide(-dividend,-divisor);
        } else if (dividend > 0) {
            return divide(-dividend,divisor);
        } else if (divisor > 0) {
            return divide(dividend,-divisor);
        }else {
            /**
             * 具体的想法是，把589÷-3，变为 (128*3+205)÷3
             * */
            int result=0,currentDivisor = divisor;
            // 因为两个参数都是负数
            while(dividend <= divisor){
                int tmp = 1;
                // 这是针对一个大数，例如-1000000，除以一个小数，例如-1 的情况
                while(dividend <= (currentDivisor <<1) && (currentDivisor << 1) < 0){
                    tmp = tmp << 1;
                    currentDivisor = currentDivisor <<1;
                }

                result = result + tmp;
                dividend = dividend-currentDivisor;
                currentDivisor = divisor;

            }
        }
        return 0;
    }
}