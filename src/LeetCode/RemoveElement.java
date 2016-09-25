package LeetCode;

/**
 * Created by yuliu on 8/26/16.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
    public static void main(String args[]) {
        RemoveElement test = new RemoveElement();
        int[] nums = {3,2,2,3};
        System.out.print(test.removeElement(nums, 3));
    }
}
