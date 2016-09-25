package LeetCode;

/**
 * Created by yuliu on 7/19/16.
 *///81题
    //what if duplicates are allowed  然后问会否影响时间复杂度
    //write a function to determine if a given target is in the array
public class SearchInRotatedArray {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] == nums[left]) {
                left++;
            }  //这个block是加进来去重的
            else if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (target >= nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        SearchInRotatedArray test = new SearchInRotatedArray();
        int[] input = new int[]{1,1,2,2,3,4,5,6,7,7,8};
        System.out.print(test.search(input, 0));
    }
}
