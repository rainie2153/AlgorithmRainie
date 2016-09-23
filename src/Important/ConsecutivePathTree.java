package Important;

import java.util.Arrays;

/**
 * Created by yuliu on 8/9/16.
 */
public class ConsecutivePathTree {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length < 3) return count;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    count++;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        ConsecutivePathTree test = new ConsecutivePathTree();
        int[] nums = {-2, 0, 1, 3};
        System.out.print(test.threeSumSmaller(nums, 2));
    }
}
