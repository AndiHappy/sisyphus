package l;

public class LeetCode079 {

    /**
     79. 单词搜索
     给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

     单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



     示例 1：


     输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     输出：true
     示例 2：


     输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     输出：true
     示例 3：


     输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     输出：false


     提示：

     m == board.length
     n = board[i].length
     1 <= m, n <= 6
     1 <= word.length <= 15
     board 和 word 仅由大小写英文字母组成


     进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？


     * */

    class Solution {
        private boolean find;

        public boolean exist(char[][] board, String word) {
            if(board == null) return false;
            int m = board.length,n=board[0].length;
            boolean[][] visted = new boolean[m][n];

            find=false;
            for(int i=0;i< m;i++){
                for(int j=0;j< n;j++){
                    //从左上角开始遍历每一个格子
                    backtracking(i,j,board,word,visted,0);
                }
            }

            return find;
        }

        /***
         i,j board 开始元素
         word：要搜索的目标单词
         visited：记录访问过的各自
         pos，记录目标单词的匹配的位置
         */
        private void backtracking(int i,int j,char[][] board,String word,boolean[][] visited,int pos){
            if(
                    i<0 || i>= board.length ||
                            j< 0 || j>= board[0].length ||
                            visited[i][j] ||
                            find ||
                            board[i][j] != word.charAt(pos)){
                return;
            }

            if(pos == word.length()-1) {
                find = true;
                return;
            }

            visited[i][j] = true; //修改当前节点的状态
            backtracking(i+1,j,board,word,visited,pos+1);
            backtracking(i-1,j,board,word,visited,pos+1);
            backtracking(i,j+1,board,word,visited,pos+1);
            backtracking(i,j-1,board,word,visited,pos+1);
            visited[i][j] =false; //修改当前节点的状态
        }
    }
}
