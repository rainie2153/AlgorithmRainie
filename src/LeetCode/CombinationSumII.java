package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuliu on 7/17/16.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (cand == null || target == 0) return res;
        Arrays.sort(cand);

        List<Integer> ans = new ArrayList<Integer>();
        dfs(cand, 0, target, ans, res);
        return res;
    }
    private void dfs(int[] cand, int cur, int target, List<Integer> ans, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(ans));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){

                ans.add(cand[i]);
                dfs(cand, i + 1, target - cand[i], ans, res);
                ans.remove(ans.size() - 1);

        }
    }
    public static void main(String args[]) {
        CombinationSumII test = new CombinationSumII();
        int[] input = new int[]{1,2,3,4,5};
        System.out.print(test.combinationSum2(input, 7));
    }
}

