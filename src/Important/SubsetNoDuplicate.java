package Important;

import java.util.*;

/**
 * Created by yuliu on 9/2/16.
 *///Given a collection of integers that might contain duplicates, nums, return all possible subsets

public class SubsetNoDuplicate {
    public List<List<Integer>> subsetsNoDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, ans, res);
        return res;
    }

    Set<List<Integer>> set = new HashSet<>();

    private void dfs(int[] nums, int level, List<Integer> ans, List<List<Integer>> res) {

        if (level == nums.length) {
            if (set.add(ans)) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        //if (set.add(nums[level])) {
        ans.add(nums[level]);
        dfs(nums, level + 1, ans, res);
        ans.remove(ans.size() - 1);
        //}
        dfs(nums, level + 1, ans, res);
    }

    public static void main(String args[]) {
        SubsetNoDuplicate test = new SubsetNoDuplicate();
        int[] nums = {1,2,2};
        test.subsetsNoDup(nums);
    }
}
