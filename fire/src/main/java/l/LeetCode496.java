package l;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode496 {
    /**
     * The next greater element of some element x in an array is the first greater element that is to
     * the right of x in the same array.
     * <p>
     * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
     * <p>
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and
     * determine the next greater element of nums2[j] in nums2.
     * If there is no next greater element, then the answer for this query is -1.
     * <p>
     * Return an array ans of length nums1.
     * length such that ans[i] is the next greater element as described above.
     * <p>
     * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
     * <p>
     * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
     * <p>
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
     * <p>
     * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
     * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * Example 2:
     * <p>
     * Input: nums1 = [2,4], nums2 = [1,2,3,4]
     * Output: [3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
     * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums1.length <= nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 104
     * All integers in nums1 and nums2 are unique.
     * All the integers of nums1 also appear in nums2.
     * <p>
     * <p>
     * Follow up: Could you find an O(nums1.length + nums2.length) solution?
     */

    class Solution {
        public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                int compare = nums2[i];
                for (int j = i + 1; j < nums2.length; j++) {
                    if (nums2[j] > compare) {
                        cache.put(compare, j);
                    }
                }
            }

            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = cache.getOrDefault(nums1[i], -1);
            }
            return result;
        }

        /**
         * 从O(n2)到 O(n),肯定只能采用空间换时间，肯定有辅助的工具
         * 我们需要记录当前的大一号的值，如果不大于当前值，或者小于当前值改怎么办尼？
         * 我们需要存储这个值，这个时候，就要求数据结构的敏感性，这个就应该想起来栈，而不是hashMap，
         * 因为hashmap，不能再遇到大一号的值的时候，尽快的能把前面的值，全部的"倒"出来！
         */

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < nums2.length; i++) {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    cache.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }

            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = cache.getOrDefault(nums1[i], -1);
            }
            return result;

        }
    }
}
