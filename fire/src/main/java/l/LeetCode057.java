package l;

import java.util.ArrayList;
import java.util.List;
import util.PrintUtil;
class LeetCode057 {


    /**
     * Note:
     *  0 <= intervals.length <= 104
     *  intervals[i].length == 2
     *  0 <= intervals[i][0] <= intervals[i][1] <= 105
     *  intervals is sorted by intervals[i][0] in ascending order.
     *  newInterval.length == 2
     *  0 <= newInterval[0] <= newInterval[1] <= 105
     *
     * */
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals == null || intervals.length < 1) return new int[][]{newInterval};

        // from intervals side think
        List<int[]> result = new ArrayList<int[]>();
        int megerIndex = 0;
        for (;megerIndex<intervals.length && intervals[megerIndex][1] < newInterval[0] ;megerIndex++){
                result.add(intervals[megerIndex]);
        }

        // from newInterval side think
        for (;megerIndex<intervals.length && intervals[megerIndex][0] <= newInterval[1];megerIndex++){
            newInterval = new int[] {Math.min(intervals[megerIndex][0],newInterval[0]),Math.max(intervals[megerIndex][1],newInterval[1])};
        }

        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (megerIndex < intervals.length) {
            result.add(intervals[megerIndex]);
            megerIndex++;
        }

        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        int[][] intervals = new int[][]{{1,3},{6,9}};
        int[] newInterval= new int[]{2,5};
        int[][] result = insert(intervals,newInterval);
        PrintUtil.pIntArray(result);
        PrintUtil.pLine();
        intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        newInterval= new int[]{4,8};
         result = insert(intervals,newInterval);
        PrintUtil.pIntArray(result);

        PrintUtil.pLine();
        intervals = new int[][]{};
        newInterval= new int[]{4,8};
        result = insert(intervals,newInterval);
        PrintUtil.pIntArray(result);

        PrintUtil.pLine();
        intervals = new int[][]{{1,5}};
        newInterval= new int[]{2,3};
        result = insert(intervals,newInterval);
        PrintUtil.pIntArray(result);

        PrintUtil.pLine();
        intervals = new int[][]{{1,5}};
        newInterval= new int[]{2,7};
        result = insert(intervals,newInterval);
        PrintUtil.pIntArray(result);
    }
}