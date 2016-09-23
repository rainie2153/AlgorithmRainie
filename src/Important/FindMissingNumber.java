package Important;

/**
 * Created by yuliu on 7/17/16.
 */
public class FindMissingNumber {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1 && nums[i] <= len && nums[i] >= 1) {
                if (nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return len + 1;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        FindMissingNumber test = new FindMissingNumber();
        int[] input = new int[]{1,3,4};
        System.out.print(test.firstMissingPositive(input));
    }

}
