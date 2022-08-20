package l;

import util.PrintUtil;

public class LeetCode074_Search_a_2D_Matirx {

    //Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
//s row.
//
//
//
// Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//
//
// Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics Array Binary Search
// 👍 3271 👎 196

    /**
     * Use binary search.
     * 根据数组的特定，直接的使用二分搜索
     * 具体的转化：
     * n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
     * an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];
     *
     * */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l=0,r = m*n-1;
        while(l <= r){
            int mid = (l+r)/2;
            // translate to matrix
            int row = mid /m;
            int col = mid %m;
            int midValue = matrix[row][col];
            if( midValue < target){
                l=mid+1;
            }else if(midValue > target){
                r=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        int[][] test = PrintUtil.twoDimensionalArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        System.out.println(searchMatrix(test,3));

        test = PrintUtil.twoDimensionalArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        System.out.println(searchMatrix(test,13));
    }
}
