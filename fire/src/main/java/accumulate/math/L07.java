package accumulate.math;

public class L07 {

    //-----------------------------------------------------------------------------------

    /**
     * first: describe the problem
     *      Assume we are dealing with an environment that could only store integers within
     *      the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem,
     *      assume that your function returns 0 when the reversed integer overflows.
     *
     * **/
    public static int change(int num){
        boolean flag = num > 0;
        num = Math.abs(num);
        int result = 0,cur=0;
        while(num >0){
            result = cur*10+num%10;
            if((result-num%10)/10 != cur){
                return 0;
            }
            cur=result;
            num = num/10;
        }
        return flag?result:-result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(change(-4123));
        System.out.println(change(123));
        System.out.println(change(10));
        System.out.println(change(2147483647));
        System.out.println(change(-2147483648));

    }
}
