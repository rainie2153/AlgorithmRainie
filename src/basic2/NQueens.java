package basic2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 6/19/16.
 */
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();

        helper(n, ans, result);
        System.out.print(result);
        return result;

    }

    private void helper(int n, List<Integer> ans, List<List<Integer>> result) {
        if (ans.size() == n) {
            result.add(new ArrayList<Integer>(ans));
            return;//return the size of current ele
        }

        for (int i = 0; i < n; i++) {//i means col which is the part of result we need to return
            //check if putting a queen at col i at cur row is valid
            if (valid(ans, i)) {
                ans.add(i);
                helper(n, ans, result);
                ans.remove(ans.size() - 1);
            }
        }
     }
    private boolean valid (List<Integer> ans, int column) {
        int row = ans.size();
        for (int i = 0; i < row; i++) {
            if (ans.get(i) == column || Math.abs(ans.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        NQueens test = new NQueens();
        int n = 8;
        test.nqueens(n);
    }


}

