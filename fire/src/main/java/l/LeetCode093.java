package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode093 {
    /**
     *
     93. 复原 IP 地址

     有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

     例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1"
     是 无效 IP 地址。

     给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
     这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。



     示例 1：

     输入：s = "25525511135"
     输出：["255.255.11.135","255.255.111.35"]
     示例 2：

     输入：s = "0000"
     输出：["0.0.0.0"]
     示例 3：

     输入：s = "1 0 1 0 23"
     输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


     提示：

     1 <= s.length <= 20
     s 仅由数字组成

     *
     * */

    /**
     * 如果采用回溯的机制，就要做一分，二分，三分，二分，总深度为 4，然后确定一分，二分，三分的界限
     * */
    List<String> result = new ArrayList<>();
    List<String> cache = new ArrayList<>();
    int n;
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        if(n>12 || n<4) return result;
        restoreIpAddresses(s,0,1);
        return result;
    }

    private void restoreIpAddresses(String s, int index,int ipIndex) {
        if(index > n) return;
        if(((n-index) > (12-(ipIndex-1)*3))) return;
        if(index == n && ipIndex ==5) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < cache.size(); j++) {
                builder.append(cache.get(j));
                if(j != cache.size()-1){
                    builder.append(".");
                }
            }
            result.add(builder.toString());
            return ;
        }

        for (int j = index; j < index+3 && j < s.length() ; j++) {
            String v= s.substring(index,j+1);
            int tmp = Integer.parseInt(v);
            boolean ismeet =  (tmp>0&&tmp<=255&&!v.startsWith("0")) || v.equals("0");
            if(ismeet){
                cache.add(v);
                restoreIpAddresses(s,j+1,ipIndex+1);
                cache.remove(cache.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode093 test = new LeetCode093();
        List<String> v =test.restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(v.toArray()));
        test.result.clear();
        v =test.restoreIpAddresses("0000");
        System.out.println(Arrays.toString(v.toArray()));
    }
}
