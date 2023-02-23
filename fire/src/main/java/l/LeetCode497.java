package l;

import java.util.Random;
import java.util.TreeMap;

/**
 497. Random Point in Non-overlapping Rectangles
 * */
public class LeetCode497 {

    /**
     You are given an array of non-overlapping axis-aligned rectangles rects
     where rects[i] = [ai, bi, xi, yi] indicates that (ai, bi) is the bottom-left corner point of the ith rectangle
     and (xi, yi) is the top-right corner point of the ith rectangle.

     Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles.
     A point on the perimeter of a rectangle is included in the space covered by the rectangle.

     Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.

     Note that an integer point is a point that has integer coordinates.

     Implement the Solution class:

     Solution(int[][] rects) Initializes the object with the given rectangles rects.
     int[] pick() Returns a random integer point [u, v] inside the space covered by one of the given rectangles.
     * */

    class Solution {

        Random random;
        //存储的是矩形的面积---> 构成矩形的数组 rects[i] = [ai(0), bi(1), xi(2), yi(3)]
        /**
         *   |------------(xi(2),ji(3))
         *   |               |
         *  (ai(0),bi(1))-----
         * */
        TreeMap<Integer,int[]> map;
        int areaSum = 0;
        public Solution(int[][] rects) {
            this.random = new Random();
            this.map = new TreeMap<>();

            for(int i = 0; i < rects.length; i++){
                int [] rectangeCoordinates = rects[i];
                int length = rectangeCoordinates[2] - rectangeCoordinates[0] + 1 ; // +1 as we need to consider edges also.
                int breadth = rectangeCoordinates[3] - rectangeCoordinates[1] + 1 ;
                areaSum += length * breadth;
                map.put(areaSum,rectangeCoordinates);

            }
        }

        public int[] pick() {
            int key = map.ceilingKey(random.nextInt(areaSum) + 1); //Don't forget to +1 here, because we need [1,area] while nextInt generates [0,area-1]
            int [] rectangle = map.get(key);
            int length = rectangle[2] - rectangle[0] + 1 ; // +1 as we need to consider edges also.
            int breadth = rectangle[3] - rectangle[1] + 1 ;
            int x = rectangle[0] + random.nextInt(length); //return random length from starting position of x
            int y = rectangle[1] + random.nextInt(breadth); // return random breadth from starting position of y

            return new int[]{x,y};
        }
    }
}
