package Important;

/**
 * Created by yuliu on 8/26/16.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
    public static void main(String args[]) {
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,1,1,2,3};
        System.out.print(test.removeDuplicates(nums));
    }
 }
