package LeetCode;

/**
 * Created by yuliu on 8/28/16.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int lmax = height[left];
        int rmax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {

                lmax = Math.max(lmax, height[left]);
                res += Math.max(0, lmax - height[left]);

                left++;
            } else {
                rmax = Math.max(rmax, height[right]);
                res += Math.max(0, rmax - height[right]);

                right--;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        TrappingRainWater test = new TrappingRainWater();
        int[] nums = {0,1,0,2,1,0,1,3,2,1};
        System.out.print(test.trap(nums));
    }
}
