package Important;

/**
 * Created by yuliu on 9/14/16.
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            if (nums[mid] == nums[left]) {
                left++;//avoid dup
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
    public static void main(String args[]) {
        FindMinInRotatedSortedArray test = new FindMinInRotatedSortedArray();
        int[] nums = {4, 4,5,5, 6, 7, 0, 1, 2};
        System.out.print(test.findMin(nums));
    }
}
