package Important;

import java.util.Arrays;

/**
 * Created by yuliu on 8/25/16.
 */
public class ThreeSumClosest {
    public int threeSumcloset(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closest = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (target - sum < diff) {
                        diff = target - sum;
                        closest = sum;
                    }
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    if (sum - target < diff) {
                        diff = sum - target;
                        closest = sum;
                    }
                    right--;
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return closest;
    }
    public static void main(String args[]) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] nums = {2,1,0,0,3,3};
        int[] nums1 = {13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
        String s = "123";
        int i = s.charAt(2) - '0';
        System.out.println(i);
        System.out.print(test.threeSumcloset(nums1, -59));
    }
}
