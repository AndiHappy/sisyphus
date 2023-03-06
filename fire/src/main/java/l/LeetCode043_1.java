package l;

public class LeetCode043_1 {

    public static void main(String[] args) {
        String v = multipliSinal('3',new char[]{'4','7','9','0','9','8'});
        System.out.println(v);
        System.out.println(3*479098);

        v = multiply("123","456");
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num2.equals("1")) return num1;
        if(num1.equals("1")) return num2;
        char[] longa = null;
        char[] shortb= null;
        if(num1.length() > num2.length()){
            longa = num1.toCharArray();
            shortb = num2.toCharArray();
        }else{
            longa = num2.toCharArray();
            shortb = num1.toCharArray();
        }

        String result = null;
        for(int i= shortb.length-1;i>=0;i--){
            String tmp = multipliSinal(shortb[i],longa);
            for(int j=0 ; j < shortb.length-1-i;j++){
                tmp = tmp+"0";
            }
            result = add(tmp,result);
        }
        return result;
    }

    public static String add(String n1,String n2){
        if(n1 == null || n1.length() == 0) return n2;
        if(n2 == null || n2.length() == 0) return n1;

        if(n1.length() > n2.length()) return add(n2,n1);
        int i = 0,carry=0;
        StringBuilder result = new StringBuilder();
        while(i <= n1.length()-1 || i <= n2.length()-1){
            int n1v = n1.length()-i > 0? n1.charAt(n1.length()-1-i)-'0':0;
            int n2v = n2.length()-i > 0? n2.charAt(n2.length()-1-i)-'0':0;
            int value = n1v+n2v+carry;
            int v = value%10;
            carry=value/10;
            result.insert(0,v);
            i++;
        }
        if(carry>0)result.insert(0,carry);
        return  result.toString();
    }

    public static String multipliSinal(char a,char[] longa){
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i =longa.length-1; i >= 0;i--){
            int value = (longa[i]-'0') * (a-'0')+carry;
            int v = value %10;
            carry = value /10;
            result.insert(0,v);
        }
        if(carry > 0) result.insert(0,carry);
        return result.toString();
    }
}
