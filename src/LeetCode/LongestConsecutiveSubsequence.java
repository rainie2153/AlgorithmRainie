package LeetCode;

import java.util.HashMap;

/**
 * Created by yuliu on 9/5/16.
 */
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] num) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // len: length of the sequence n is in
                int len = left + right + 1;
                map.put(n, len);

                // keep track of the max length
                max = Math.max(max, len);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, len);
                map.put(n + right, len);
            }
        }
        return max;
    }
    public static void main(String args[]) {
        LongestConsecutiveSubsequence test = new LongestConsecutiveSubsequence();
        int[] nums = {3,1,5,4,2,900,32,123,88};
        int[] nums1= {111,4,222,3,2};
        System.out.print(test.longestConsecutive(nums1));
    }
}
