package LeetCode;

/**
 * Created by yuliu on 9/14/16.
 * Find contiguous subarray within an array which has largest product.
 * [2,3,-2,4] --> [2,3] has largest product 6
 * [-2,-5,1,5] largest product 50
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxProduct = 1;
        int minProduct = 1;
        for(int i = 0; i < nums.length; i++) {
            int tempMax = maxProduct;
            int tempMin = minProduct;
            maxProduct = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * tempMin));
            minProduct = Math.min(nums[i], Math.min(nums[i] * tempMin, nums[i] * tempMax));
            max = Math.max(max, maxProduct);
        }
        return max;
    }
    public static void main(String args[]) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] nums = {-5, -2,1,5};
        System.out.print(test.maxProduct(nums));
    }

}
