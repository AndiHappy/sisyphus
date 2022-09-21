package accumulate.String;

public class L28 {

    public static void main(String[] args) {
        System.out.println(strStr("abcdfgderfh", "der"));
    }

    /**
     * 字符串相关
     * */
    public static int strStr(String source,String target){
        if(target == null) return -1;
        if(target.isEmpty()) return 0;
        // 首先找第一个匹配的字符
        char firstTarget = target.charAt(0);
        // 验证的最远点
        int max = source.length() - target.length();
        /**
         * ".......Msource"
         * ".......Mtarget"
         *  i作为一个index的值，最大值为字符M对应的index，也就是max值
         * */
        for (int i = 0; i <= max; i++) {
            //寻找第一个匹配点
            if(source.charAt(i) != firstTarget) while (++i <= max && source.charAt(i) != firstTarget);
            //需要debug
            if(i <= max){
                int j=i+1,end = j+target.length()-1;
                for (int k = 1; j <end && source.charAt(j) == target.charAt(k) ;j++, k++) ;
                if(j == end){
                    return i;
                }
            }
        }
        return -1;
    }
}
