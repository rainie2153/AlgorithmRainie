package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 8/6/16.
 */

public class Combination4 {
    /*Method1: bottom-up DP
* target is the sum of numbers in nums, we need one more number to reach target. the number can be any
* one in the array. So # of combinations of target, M[target] = sum[M[target - nums[i]]*/

    public int combinationSum4(int[] nums, int target) {
        int[] M = new int[target + 1];
        M[0] = 1;
        for (int i = 1; i <= target ; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    M[i] = M[i] + M[i - nums[j]];
                }
            }
        }
        return M[target];
    }
    /*Method2: recursion这个解法我觉得是target^nums.length*/
    public int combinationMethod2(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationMethod2(nums, target - nums[i]);
            }
        }
        return res;
    }
    /*Method3. DP top down
    * we need to store the intermediate results to avoid the combination sum being caculated many time,
    * we can use an array to save those results and check if there is already a result before calculation
    * fill the array with -1 which indicates that the result hasnt been calculated yet. 0 is not a good choice
    * because it means there is no combination sum for the target*/
    public int combMethod3(int[] nums, int target) {
        int[] M = new int[target + 1];
        Arrays.fill(M, -1);
        M[0] = 1;
        if (M[target] != -1) {
            return M[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combMethod3(nums, target - nums[i]);
            }
        }
        M[target] = res;
        return res;
    }

    public static void main(String args[]) {
        Combination4 test = new Combination4();
        int[] input = new int[]{1,2,3};
        System.out.print(test.combMethod3(input, 7));
    }
}
