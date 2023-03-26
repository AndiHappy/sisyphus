package l;

public class LeetCode081 {
    /**

     81. 搜索旋转排序数组 II
     已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。

     在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。

     给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。

     你必须尽可能减少整个操作步骤。



     示例 1：

     输入：nums = [2,5,6,0,0,1,2], target = 0
     输出：true
     示例 2：

     输入：nums = [2,5,6,0,0,1,2], target = 3
     输出：false


     提示：

     1 <= nums.length <= 5000
     -104 <= nums[i] <= 104
     题目数据保证 nums 在预先未知的某个下标上进行了旋转
     -104 <= target <= 104


     进阶：

     这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
     这会影响到程序的时间复杂度吗？会有怎样的影响，为什么

     * */
    public static void main(String[] args) {
        LeetCode081 test = new LeetCode081();
        boolean result = test.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},2);
        System.out.println(result);
        result = test.search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1},13);
        System.out.println(result);

        result = test.search(new int[]{2,5,6,0,0,1,2},0);
        System.out.println(result);

        result = test.search(new int[]{2,5,6,0,0,1,2},3);
        System.out.println(result);
    }
    /**
     int from = 0; int to = n-1;
     while(from < to){
        int mid = from+ (to-from)/2;
        if(A[mid] >= A[to]){
            from=mid+1;
        }else{
            to = mid;
        }
     }
     System.out.println(to);

     这样写的话，循环不变式，就是 [from-mid) 之间的值大于等于 [mid to)

     但是针对：
     1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1
     left              mid              right
     * */

    public boolean search(int[] nums, int target) {
        if(nums.length ==1) return nums[0] == target;
        int left =0,right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target ) return true;
            while (left < nums.length && nums[left] == nums[mid]) left++;
            while (right >0 && nums[right] == nums[mid]) right--;
            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else{
                if(nums[mid] < target && target <= nums[right])
                    left = mid  + 1;
                else
                    right = mid - 1;
            }
        }
        return  false;
    }

    public boolean search_good(int[] nums, int target) {
      int left =0,right = nums.length-1;
      while(left <= right){
          int mid = left+(right-left)/2;
          if(nums[mid] == target ) return true;
          while (left <= mid && nums[left] == nums[mid]) left++;
          if(left > mid){
              left = mid+1;
              continue;
          }
          if(nums[left] < nums[mid]){
              if(nums[left] <= target && target < nums[mid]){
                  right = mid-1;
              }else {
                  left = mid+1;
              }
          }else{
              if(nums[mid] < target && target <= nums[right])
                  left = mid  + 1;
              else
                  right = mid - 1;
          }
      }
      return  false;
    }


}
