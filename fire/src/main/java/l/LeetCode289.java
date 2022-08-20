package l;

import util.PrintUtil;

public class LeetCode289 {

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        int[][] result = PrintUtil.twoDimensionalArray("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]");
        PrintUtil.pIntArray(result);
        System.out.println(result);
        PrintUtil.pIntArray(result);
    }

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        if (rows == 0)  return;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //周围八个位置有多少个 1
                int count = getOnes(r, c, rows, cols, board);
                //count == 3 的时候下一状态是 1, 或者 count == 2, 并且当前是 1 的时候下一状态是 1
                if(count == 3 || (board[r][c] == 1) && count == 2){
                    board[r][c] |= 2; //2 的二进制是 10，相当于将第二位 置为 1
                }
            }
        }

        //将所有数字还原
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //右移一位还原
                board[r][c] >>= 1;
            }
        }
    }
    //需要统计周围八个位置 1 的个数
    private int getOnes(int r, int c, int rows, int cols, int[][] board) {
        int count = 0;
        for (int i = Math.max(r - 1, 0); i <= Math.min(r + 1, rows - 1); i++) {
            for (int j = Math.max(c - 1, 0); j <= Math.min(c + 1, cols - 1); j++) {
                count += board[i][j] & 1;
            }
        }
        //如果原来是 1, 需要减去 1
        count -= board[r][c] & 1;
        return count;
    }

    public static void gameOfLife1(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // count 1 around board[i][j]
                int count1 = countOnes(i,j,rows,cols,board);
                if(board[i][j] == 0 && count1 == 3){
                    //  如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    board[i][j]=-1; // from 0 change to 1
                }
                if(board[i][j] == 1 && (count1 > 3 || count1 <2 )){
                    //如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                    // 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                    board[i][j] = -2; // from 1 change to 0
                }
            }
        }

        //将所有数字还原
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == -1) {
                    board[r][c] = 1;
                }
                if (board[r][c] == -2) {
                    board[r][c] = 0;
                }
            }
        }


    }

    //需要统计周围八个位置 1 和 -2 的个数
    private static int countOnes(int r, int c, int rows, int cols, int[][] board) {
        int count = 0;
        // 上
        if (r - 1 >= 0 && (board[r - 1][c] == 1 || board[r - 1][c] == -2)) {
            count++;
        }
        // 下
        if (r + 1 < rows && (board[r + 1][c] == 1 || board[r + 1][c] == -2)) {
            count++;
        }
        // 左
        if (c - 1 >= 0 && (board[r][c - 1] == 1 || board[r][c - 1] == -2)) {
            count++;
        }
        // 右
        if (c + 1 < cols && (board[r][c + 1] == 1 || board[r][c + 1] == -2)) {
            count++;
        }
        // 左上
        if (c - 1 >= 0 && r - 1 >= 0 && (board[r - 1][c - 1] == 1 || board[r - 1][c - 1] == -2)) {
            count++;
        }
        // 左下
        if (c - 1 >= 0 && r + 1 < rows && (board[r + 1][c - 1] == 1 || board[r + 1][c - 1] == -2)) {
            count++;
        }
        // 右上
        if (c + 1 < cols && r - 1 >= 0 && (board[r - 1][c + 1] == 1 || board[r - 1][c + 1] == -2)) {
            count++;
        }
        // 右下
        if (c + 1 < cols && r + 1 < rows && (board[r + 1][c + 1] == 1 || board[r + 1][c + 1] == -2)) {
            count++;
        }
        return count;
    }

}
