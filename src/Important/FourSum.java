package Important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuliu on 8/26/16.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        KSum(res, ans, nums, target, 4, 0, nums.length - 1);
        return res;
    }
    private void KSum(List<List<Integer>> res, List<Integer> ans, int[] nums, int target, int k, int left, int right) {
        //case1  k == 0
        if (k == 0 || nums.length == 0 || left > right) {
            return;
        }
        //case2 k == 1
        if (k == 1) {
            for (int i = left; i <= right; i++) {
                if(nums[i] == target) {
                    ans.add(nums[i]);
                    res.add(new ArrayList<Integer>(ans));
                    ans.remove(ans.size() - 1);
                }
            }
            return;
        }
        //case3 k == 2
        if (k == 2) {
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(new ArrayList<Integer>(ans));
                    ans.remove(ans.size() - 1);
                    ans.remove(ans.size() - 1);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
             }
            return;
        }
        //去掉一些不可能
        if (k * nums[left] > target || k * nums[right] < target) {
            return;
        }
        //case4 k > 2
        for (int i = left; i <= right - k + 1; i++) {
            if (i > left && nums[i] == nums[i - 1]) {
                continue;
            }
            if (k * nums[i] <= target) {
                ans.add(nums[i]);
                KSum(res, ans, nums, target - nums[i], k - 1, i + 1, right);
                ans.remove(ans.size() - 1);
            }
        }
        return;
    }
    public static void main(String args[]) {
        FourSum test = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(test.fourSum(nums, 0));
    }

}
