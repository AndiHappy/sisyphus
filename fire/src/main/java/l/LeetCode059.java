package l;

public class LeetCode059 {

    /**
     *
     59. 螺旋矩阵 II
     给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。



     示例 1：


     输入：n = 3
     输出：[[1,2,3],[8,9,4],[7,6,5]]
     示例 2：

     输入：n = 1
     输出：[[1]]


     提示：

     1 <= n <= 20
     * */

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            if(n==1){
                matrix[0][0]=1;
            }else{
                int left =0; int right = n-1;
                int up = 0; int down = n-1;
                int index=1;
                while(left <= right && up <= down){
                    for(int i = left ; i <= right ; i++){
                        matrix[up][i] = index;
                        index++;
                    }
                    up++;

                    for(int i = up;i<=down;i++){
                        matrix[i][right] = index;
                        index++;
                    }
                    right--;

                    for(int i = right;i >= left && down >= up;i--){
                        matrix[down][i] = index;
                        index++;
                    }
                    down--;

                    for( int i = down ; i >= up && left <= right;i--){
                        matrix[i][left]=index;
                        index++;
                    }
                    left++;
                }
            }

            return matrix;
        }
    }
}
