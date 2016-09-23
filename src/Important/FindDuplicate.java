package Important;

/**
 * Created by yuliu on 7/30/16.
 */
public class FindDuplicate {
//    public int findDuplicate(int[] nums) {
//        int left = 1, right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int count = countSmall(nums, mid);
//            if (count > mid) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//
//    public int countSmall(int[] nums, int target) {
//        int count = 0;
//        for (int i : nums) {
//            if (i <=  target) count++;
//        }
//        return count;
//    }
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;


        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


    public static void main(String args[]) {
        FindDuplicate test = new FindDuplicate();
        int[] input = {3,2,1,5,5,4};
        System.out.print(test.findDuplicate(input));
        System.out.print('1'+'2');
    }
}
