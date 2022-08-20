package accumulate.math;

public class L08 {

    //-----------------------------------------------------------------------------------

    /**
     * first： describe the problem
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit
     * signed integer (similar to C/C++'s atoi function).
     *
     * 1. Read in and ignore any leading whitespace.
     *
     * 2. Check if the next character (if not already at the end of the string) is '-'or '+'.
     *
     * Read this character in if it is either.
     * This determines if the final result is negative or positive respectively.
     * Assume the result is positive if neither is present.
     *
     * Read in next the characters until the next non-digit character or the end of the input is reached.
     *
     * The rest of the string is ignored.
     * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
     * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
     *
     * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp
     * the integer so that it remains in the range. Specifically, integers less than -231
     * should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
     *
     * Return the integer as the final result.
     *
     * secone: use math,iteration_control
     * third：write the code
     * fourth：test the case
     *
     * */
    public static int myAtoi(String s) {
        int result = 0;
        boolean ispositive = true;
        //  Read in and ignore any leading whitespace.
        int i =0;
        while(i < s.length() && ' ' == s.charAt(i)) i++;

        // Check if the next character (if not already at the end of the string) is '-'or '+'.
        if(i < s.length() &&(s.charAt(i) == '-' || s.charAt(i) == '+')) {
            ispositive=s.charAt(i) != '-';
            i++;
        }

        while(i < s.length() && Character.isDigit(s.charAt(i))){
            char tmp = s.charAt(i);
            if((Integer.MAX_VALUE - (tmp-'0'))/10 < result) return ispositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            result = result*10+(tmp-'0');
            i++;
        }

        return ispositive?result:-result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-2147483648"));

    }

}
