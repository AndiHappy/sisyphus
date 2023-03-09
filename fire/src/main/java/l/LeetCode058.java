package l;

class LeetCode058 {
    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        // 代码的控制，写的不错
        while (left <= right) {
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            for (int j = right; j >= left; j --) {
                ret[down][j] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }

    /**
     *
     58. 最后一个单词的长度
     给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。

     单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。



     示例 1：

     输入：s = "Hello World"
     输出：5
     解释：最后一个单词是“World”，长度为5。
     示例 2：

     输入：s = "   fly me   to   the moon  "
     输出：4
     解释：最后一个单词是“moon”，长度为4。
     示例 3：

     输入：s = "luffy is still joyboy"
     输出：6
     解释：最后一个单词是长度为6的“joyboy”。


     提示：

     1 <= s.length <= 104
     s 仅有英文字母和空格 ' ' 组成
     s 中至少存在一个单词

     * */

    class Solution {
        public int lengthOfLastWord(String s) {
            int i = s.length()-1;
            while(s.charAt(i) == ' ') i--;
            int reuslt =0;
            while(i>=0 && s.charAt(i) != ' '){
                reuslt++;
                i--;
            }
            return reuslt;

        }
    }
}