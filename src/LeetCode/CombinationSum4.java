package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 8/8/16.
 */
public class CombinationSum4 {
    public int combinationSum4 (int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(array, target, map);
    }
    private int helper(int[] array, int target, Map<Integer, Integer> map) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i ++) {

            sum += helper(array, target - array[i], map);
        }
        map.put(target, sum);
        return sum;
    }
    public static void main(String args[]) {
        CombinationSum4 test = new CombinationSum4();
        int[] nums = {3, 1};
        System.out.print(test.combinationSum4(nums, 4));
    }
}
