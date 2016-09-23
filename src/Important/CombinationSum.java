package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/17/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if (candidates == null || target == 0) return res;
        //Arrays.sort(candidates);  无需sort
        dfs(candidates, target, 0, ans, res);
        return res;
    }

    public void dfs(int[] candidates, int target, int level, List<Integer> ans, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(ans));
            //return;
        }
        if (target < 0) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            if (target >= candidates[i]) {

                ans.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public static void main(String args[]) {
        CombinationSum test = new CombinationSum();
        int[] input = new int[]{2,3,6,7};
        System.out.print(test.combinationSum(input, 6));
    }
}
