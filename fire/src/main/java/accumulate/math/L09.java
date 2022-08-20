package accumulate.math;

public class L09 {


    //-----------------------------------------------------------------------------------

    /**
     * first: describe the problem
     *     Given an integer x, return true if x is palindrome integer.
     * second: use math
     * third: write the code
     * fourth: test the case
     * */

    public static boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x != 0)) return false;
        if(x>=0 && x < 10) return true;
        int result = 0;
        int cur = x;
        while(cur > 0){
            result = result*10+cur%10;
            if(result < 0) return false;
            cur= cur/10;
        }
        return result == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1211));
    }

}
