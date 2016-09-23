package Important;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuliu on 9/5/16.
 */
public class LongestSubsequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    count++;
                    num++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
    public static void main(String args[]) {
        LongestSubsequence test = new LongestSubsequence();
        int[] nums = {3,1,5,4,2,900,32,123,88};
        System.out.print(test.longestConsecutive(nums));
    }
}
