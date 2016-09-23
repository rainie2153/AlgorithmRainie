package Important;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuliu on 8/29/16.
 */
public class Permutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, res, 0, ans);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, int level, List<Integer> ans) {
        if (level == nums.length) {
            res.add(new ArrayList<>(ans));
            return;//这个return是必须要写的,因为void要返回下
        }
        Set<Integer> set = new HashSet<>();
        for (int i = level; i < nums.length; i++) {
            if(set.add(nums[i])) {
                swap(nums, level, i);
                ans.add(nums[level]);
                helper(nums, res, level + 1, ans);
                ans.remove(ans.size() - 1);
                swap(nums, level, i);

            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String args[]) {
        Permutations test = new Permutations();
        int[] nums = {1,1,3};
        System.out.print(test.permuteUnique(nums));
    }
}
