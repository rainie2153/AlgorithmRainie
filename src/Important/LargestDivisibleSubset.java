package Important;

import java.util.Arrays;

/**
 * Created by yuliu on 7/31/16.
 */
public class LargestDivisibleSubset {
    public int[] largestDivisibleSubset(int[] nums) {
        if (nums.length < 2)
            return nums;
        else {
            Arrays.sort(nums);
            int[] parent = new int[nums.length];
            int[] count = new int[nums.length];
            int max = 0, maxind = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] % nums[i] == 0 && count[i] < 1 + count[j]) {
                        count[i] = 1 + count[j];
                        parent[i] = j;
                        if (count[i] > max) {
                            max = count[i];
                            maxind = i;
                        }
                    }
                }
            }
            int[] res = new int[max];
            for (int i = 0; i < max; i++) {
                res[i] = nums[maxind];
                maxind = parent[maxind];
            }
            return res;
        }
    }

    public static void main (String[] args) {
        LargestDivisibleSubset test = new LargestDivisibleSubset();
        int[] nums = new int[] {1,2,3,8};
        System.out.print(test.largestDivisibleSubset(nums));
    }

}
