package LeetCode;

/**
 * Created by yuliu on 7/16/16.
 */
public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;//因为需要remove所以相等的时候判断无法覆盖屌原来element
        for (fast = 1; fast < nums.length; fast++) {
            if(nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;//返回的是length , slow is just a index so we add 1
    }
    public static void main(String args[]) {
        RemoveDup test = new RemoveDup();
        int[] input = new int[]{1,1,2,2,3,3};
        System.out.print(test.removeDuplicates(input));
    }
}
