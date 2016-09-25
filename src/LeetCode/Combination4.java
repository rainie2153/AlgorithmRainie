package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 8/6/16.
 */
public class Combination4 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (num > i)
                    break;
                else if (num == i)
                    res[i] = res[i] + 1;
                else
                    res[i] += res[i - num];
            }
        }
        return res[target];
    }
    public static void main(String args[]) {
        Combination4 test = new Combination4();
        int[] input = new int[]{1,2,3};
        System.out.print(test.combinationSum4(input, 4));
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(1, "b");
    }
}
