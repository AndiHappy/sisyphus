package accumulate.iteration_control;

public class L38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));

    }
    public static String countAndSay(int n) {
        if(n == 1) return "1";
        if(1 == n) return "1";
        if(2 == n) return  "11";
        String pre = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        char cur = pre.charAt(0);
        int repeate = 1;
        for (int i = 1; i < pre.length(); i++) {
            char tmp = pre.charAt(i);
            if(cur == tmp){
                repeate++;
            }else{
                result.append(repeate).append(cur);
                cur = tmp;
                repeate=1;
            }
        }
        result.append(repeate).append(cur);
        return result.toString();
    }
}
