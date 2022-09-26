package accumulate.sort;

public class L33 {
    public static void main(String[] args) {
        System.out.println("Keep Happy !");
//        System.out.println(search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(search(new int[]{1,3,5},5));
    }

    public static int search(int a[], int target){
        if(null == a || a.length == 0) return -1;
        if(a.length == 1) return a[0]==target?0:-1;

        int n = a.length;int turn=n-1;
        //寻找转折点，方法①
        for (; turn >0 && a[turn] > a[turn-1]; turn--);
        //寻找转折点，方法②
        int start = 0; int end = n-1;
        while(start < end){
            int mid = start+ (end-start)/2;
            if(a[mid] > a[end]){
                start=mid+1;
            }else{
                end = mid;
            }
        }
        turn=end;


        int from =turn; int to = turn+a.length;
        while(from <= to){
            int mid = (from+to)/2;
            if(a[mid%n] > target){
                to = mid-1;
            } else if (a[mid%n] < target) {
                from=mid+1;
            }else {
                return mid%n;
            }
        }
        return -1;
    }
}
