package l;//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
//

import java.util.Arrays;

public class LeetCode006 {
    
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows)
            return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                builders[j].append(s.charAt(i));
                i++;
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                builders[j].append(s.charAt(i));
                i++;
            }
        }
        String res = "";
        for (int jj = 0; jj < numRows; jj++) {
            res += builders[jj].toString();
        }
        return res;
    }


    static class Solution {
        // 这种类型的题目，就抄写代码了
        public String convert(String s, int numRows) {
            //单行输出，特殊的情况处理
            if(s == null || s.length() <= numRows ) return s;
            //采用多行的StringBuilder，简化控制的逻辑
            StringBuilder[] builders = new StringBuilder[numRows];
            for (int i = 0; i < builders.length; i++) {
                builders[i]=new StringBuilder();
            }
            int i =0;
            while (i < s.length()){
                //从上到下的第一行的遍历输出
                for(int j1=0;j1<numRows && i < s.length();j1++){
                    builders[j1].append(s.charAt(i));
                    i++;
                }

                //从下到上的截断输出

                for(int j2 = numRows-2; j2>0 && i < s.length();j2--){
                    builders[j2].append(s.charAt(i));
                    i++;
                }
            }

            StringBuilder res = new StringBuilder();
            for(int j3 =0 ; j3 < numRows;j3++){
                res.append(builders[j3].toString());
            }
            return res.toString();
        }
    }


    public static void main(String[] args) {
        LeetCode006.Solution s = new LeetCode006.Solution();
        s.convert("PAYPALISHIRING",3);
    }
}












