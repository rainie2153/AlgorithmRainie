package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 9/25/16.
 * Given an array nums and a target value k, find the max length of a subarray that sums to k, if there
 * isn't one, return 0 instead.
 * example1.nums = [1,-1,5,-2,3] k = 3 return 4 because the subarray[1, -1, 5, -2]sums to 3 and is the longest.
 * example2.num = [-2,-1,2,1] k = 1 return 2 because the subarray[-1,2] sums to 1 and is the longest.
 * O(n)
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] presum = new int[nums.length + 1];
        presum[0] = 0;//0 1 0 5 3 6
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//recorde the num and its index
        int max = 0;
        for (int i = 0; i < presum.length; i++) {
            if (map.containsKey(presum[i] - k)) {
                int length = i - map.get(presum[i] - k);
                max = Math.max(max, length);
            }
            if (!map.containsKey(presum[i])) {
                map.put(presum[i], i);
            }
        }
        return max;
    }

    public static void main(String args[]) {
         MaximumSizeSubarraySumEqualsK test = new MaximumSizeSubarraySumEqualsK();
         int[] nums = {1,2,3,4};
         System.out.print(test.maxSubArrayLen(nums, 6));
    }
}
