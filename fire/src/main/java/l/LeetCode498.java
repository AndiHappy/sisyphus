package l;

import java.util.ArrayList;
import java.util.List;

/**
 * 498. Diagonal Traverse
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 *
 * Example 2:
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 *
 * */
public class LeetCode498 {
    
    public static void main(String[] args) {
        System.out.println("keep happy!");
        int[][] mat = new int[][]{{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
        System.out.println(mat[0].length);
        System.out.println(mat.length);
        findDiagonalOrder(mat);
    }

    /**
     *
     * [1,2,3,4]
     * [5,6,7,8]
     * {9,0,1,2}
     * {3,4,5,6}
     * */

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        ArrayList<List<Integer>> tmpList = new ArrayList<>(m+n-1);
        for (int i = 0; i < m+n-1 ; i++) {
            tmpList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> tmp = tmpList.get(j+i);
                tmp.add(mat[i][j]);
            }
        }

        boolean flag = true;
        int[] result = new int[mat.length*mat[0].length];
        int index=0;
        for (int i = 0; i <tmpList.size() ; i++) {
            if(flag) {
                for (int j = tmpList.get(i).size()-1; j >=0 ; j--) {
                    result[index]=tmpList.get(i).get(j);
                    index++;
                }
                flag=false;
            }else{
                flag=true;
                for (int j = 0; j < tmpList.get(i).size() ; j++) {
                    result[index]=tmpList.get(i).get(j);
                    index++;
                }
            }
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }
}
