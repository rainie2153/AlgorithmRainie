package mianjing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 9/25/16.
 */
public class Combination {
    public List<List<Integer>> combination(int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combination(1, target, res, ans);
        return res;
    }
    private void combination(int level, int target, List<List<Integer>> res, List<Integer> ans) {
        if (target == 0) {
            System.out.print(ans);
            res.add(new ArrayList<>(ans));
        }

        for (int i = level; i <= target; i++) {
            ans.add(i);
            combination(i, target - i, res, ans);
            ans.remove(ans.size() - 1);
        }
    }
    public static void main(String args[]) {
        Combination test = new Combination();
        test.combination(4);
    }
}
