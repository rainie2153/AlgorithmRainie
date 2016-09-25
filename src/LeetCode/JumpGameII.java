package LeetCode;

/**
 * Created by yuliu on 8/29/16.
 */
public class JumpGameII {
    public int minNumberOfJumps(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;


        int[] M = new int[len];

        M[0] = 0;
        for (int i = 1; i < len; i++) {
            M[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i && M[j] != -1) {
                    if (M[i] == -1 || M[i] > M[j] + 1) {
                        M[i] = M[j] + 1;
                    }
                }

            }
        }
        return M[len - 1];
    }
    public static void main(String args[]) {
        JumpGameII test = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.print(test.minNumberOfJumps(nums));
    }
}
