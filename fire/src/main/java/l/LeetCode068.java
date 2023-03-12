package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode068 {

    /**
     * 
     We start with left being the first word.

     findRight: Then we greedily try to go as far right as possible until we fill our current line.

     Then we justify one line at a time.

     justify: In all cases we pad the right side with spaces until we reach max width for the line;

     If it's one word then it is easy, the result is just that word.
     If it's the last line then the result is all words separated by a single space.
     Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space until it is gone.

     * */
    public static void main(String[] args) {
        LeetCode068 test = new LeetCode068();
        List<String> r = Arrays.asList("This", "is", "an", "example", "of", "text", "justification.");
        String[] rs = new String[r.size()];
        r.toArray(rs);
       r = test.fullJustify(rs,16);
       for (String d:r){
           System.out.println(d);
       }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");

        return padResult(result.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }


    /**

     68. 文本左右对齐
     给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

     你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

     要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

     文本的最后一行应为左对齐，且单词之间不插入额外的空格。

     注意:

     单词是指由非空格字符组成的字符序列。
     每个单词的长度大于 0，小于等于 maxWidth。
     输入单词数组 words 至少包含一个单词。


     示例 1:

     输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
     输出:
     [
     "This    is    an",
     "example  of text",
     "justification.  "
     ]
     示例 2:

     输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
     输出:
     [
     "What   must   be",
     "acknowledgment  ",
     "shall be        "
     ]
     解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。
     第二行同样为左对齐，这是因为这行只包含一个单词。
     示例 3:

     输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
     输出:
     [
     "Science  is  what we",
     "understand      well",
     "enough to explain to",
     "a  computer.  Art is",
     "everything  else  we",
     "do                  "
     ]


     提示:

     1 <= words.length <= 300
     1 <= words[i].length <= 20
     words[i] 由小写英文字母和符号组成
     1 <= maxWidth <= 100
     words[i].length <= maxWidth

     * */

    class Solution{

        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            int right = 0, n = words.length;
            while(true){
                int left = right;// 当前行的第一个单词，在 words 数组中的位置
                int sumLen =0; //统计这一行单词长度的和
                // 循环确定，当前行可以放多少单词，注意单词和单词之间，至少有一个空格
                while(right < n && sumLen+ words[right].length() + right-left <= maxWidth){
                    sumLen += words[right].length();
                    right++; // right++，不仅仅是 index 的挪动，并且 right-left 为空格的数量
                }

                int numWords = right-left;
                int numSpaces = maxWidth-sumLen;

                if(right == n){
                    //当前行是最后一行，单词左对齐以后，且单词之间只有一个控制，在行末填充剩余空格就行了。
                    StringBuffer sb = join(words,left,n,"");
                    sb.append(blank(maxWidth-sb.length()));
                    result.add(sb.toString());
                    return result;
                }

                int avgSpaces = numSpaces / (numWords-1);
                int extraSpaces = numSpaces %(numWords-1);
                StringBuilder sb = new StringBuilder();
                sb.append(join(words,left,left+extraSpaces+1,blank(avgSpaces+1)));
                sb.append(blank(avgSpaces));
                sb.append(join(words,left+extraSpaces+1,right,blank(avgSpaces)));
                result.add(sb.toString());
            }
        }

        // blank 返回长度为 n 的由空格组成的字符串
        public String blank(int n) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; ++i) {
                sb.append(' ');
            }
            return sb.toString();
        }

        // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
        public StringBuffer join(String[] words, int left, int right, String sep) {
            StringBuffer sb = new StringBuffer(words[left]);
            for (int i = left + 1; i < right; ++i) {
                sb.append(sep);
                sb.append(words[i]);
            }
            return sb;
        }
    }

}
