package l;

import java.util.Arrays;

public class LeetCode274 {

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        int[] citations = new int[]{0,1,5,5,6};
        System.out.println(hIndex(citations));
    }

    public int hIndex1(int[] citations) {

        // [0,1,3,5,6]
        // h-index=3， means:
        // >=3 elements bigger or equal to h-index=3
        // (5- 3) elemens smaller or equal to h-index=3

        // [0,1,2,5,6]
        // h-index=2  means: >=2 elements bigger or equal to h-index=2

        // [0,1,2,5,6]
        //  5 4 3 4 1

        int len = citations.length;
        int lo=1;int hi=len-1;

        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(citations[mid] == len-mid){
                return len-mid;
            }else if(citations[mid] < len-mid ){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }

        return len-lo;


    }

    public static int hIndex(int[] citations) {
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
}
