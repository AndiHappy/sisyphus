package l;

import java.util.ArrayList;

public class LeetCode060 {

    /*
    60. 排列序列
给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。



示例 1：

输入：n = 3, k = 3
输出："213"
示例 2：

输入：n = 4, k = 9
输出："2314"
示例 3：

输入：n = 3, k = 1
输出："123"


提示：

1 <= n <= 9
1 <= k <= n!

    * */

    // 具体的解题步骤

    /**
     * 对于n=4, k=15 找到k=15排列的过程:
     * <p>
     * 1 + 对2,3,4的全排列 (3!个)
     * 2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
     * 3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
     * 4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)
     * <p>
     *
     */


    public static void main(String[] args) {
        System.out.println("keep happy!!");
        LeetCode060 test = new LeetCode060();
//        for (int i = 1; i < 6 ; i++) {
//            String v = test.getPermutation(3, i);
//            System.out.println(v);
//        }
        String v = test.getPermutation(3, 4);
        System.out.println(v);
    }

    int[] jiecheng = null;
    public String getPermutation(int n, int k) {
        jiecheng = new int[n + 1];
        jiecheng[0] = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            jiecheng[i] = jiecheng[i - 1] * i;
            result.add(i);
        }
        StringBuilder builder = new StringBuilder();
        // k 从 0 开始，不然这样第一个值，就会变为  result.get(k) ,k 就变为了 k-1
        getPermutation(n, result, k-1, builder, 1);
        return builder.toString();
    }

    private void getPermutation(int n, ArrayList<Integer> result, int k, StringBuilder builder, int from) {
        if(from > n) return;
        int index = k / jiecheng[n - from];
        builder.append(result.remove(index));
        k = k - index * jiecheng[n - from];
        getPermutation(n, result, k, builder, from + 1);
    }


}
