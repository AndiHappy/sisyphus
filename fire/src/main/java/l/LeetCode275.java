package l;

import java.util.Arrays;

public class LeetCode275 {
    public static void main(String[] args) {
        System.out.println("keep Happy boy");

    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int k =0,res=0;
        for(int i=citations.length-1;i>=0;i--){
            k++;
            if(citations[i]>=k){
                res=Math.max(res,k);
            }
        }
        return res;

    }


//    This type of problems always throw me off, but it just takes some getting used to.
//    The idea behind it is some bucket sort mechanisms. First, you may ask why bucket sort.
//    Well, the h-index is defined as the number of papers with reference greater than the number.
//    So assume n is the total number of papers, if we have n+1 buckets, number from 0 to n, then for any paper with reference corresponding to the index of the bucket,
//    we increment the count for that bucket.
//    The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.
//
//    Then we iterate from the back to the front of the buckets, whenever
//    the total count exceeds the index of the bucket, meaning that we have the index number of papers
//    that have reference greater than or equal to the index. Which will be our h-index result.
//    The reason to scan from the end of the array is that we are looking for the greatest h-index.
//    For example, given array [3,0,6,5,1], we have 6 buckets to contain how many papers have the corresponding index.
//    Hope to image and explanation help.
//

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
