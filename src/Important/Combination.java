package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 8/31/16.
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(1, n, k, ans, res);
        return res;
    }
    private void dfs(int i, int n, int k, List<Integer> ans, List<List<Integer>> res) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
        }
        if (i > n || ans.size() > k) {//出界判断
            return;
        }
        ans.add(i);
        dfs(i + 1, n, k, ans, res);
        ans.remove(ans.size() - 1);

        dfs(i + 1, n, k, ans, res);
    }

}
