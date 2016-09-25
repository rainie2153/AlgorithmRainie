package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/29/16.
 */
public class FactorCombination {
    public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (n <= 1) return res;
    dfs(n, 2, new ArrayList<Integer>(), res);
    res.remove(res.size() - 1);
    return res;
}

    public void dfs(int n, int index, List<Integer> ans, List<List<Integer>> res) {
        if (n == 1) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
                dfs(n / i, i, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public static void main(String args[]) {
        FactorCombination test = new FactorCombination();

        System.out.print(test.getFactors(16));
    }

}
