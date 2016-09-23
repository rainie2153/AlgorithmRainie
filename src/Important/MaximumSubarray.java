package Important;

/**
 * Created by yuliu on 8/30/16.
 *///subarray means contiguous
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curMax = nums[0];
        /*dp[i] means the largest sum of subarray ending at index i
        * dp[i] = nums[i]   if dp[i - 1] <= 0
        * dp[i] = dp[i - 1] + nums[i] if dp[i - 1] > 0
        * so that we can reduce the space consumption by recording the largest sum*/

        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
