package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/15/16.
 */
public class AllValidParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        char[] cur = new char[n * 2];
        helper(cur, 0, n, n, result);
        return result;
    }
    private void helper(char[] cur, int index, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }
        if (left > 0) {
            cur[index] ='(';
            helper(cur, index + 1, left - 1, right, result);

        }
        if (right > 0) {
            cur[index] = ')';
            helper(cur, index + 1, left, right - 1, result);
        }
        if (right > left) {//left means left ( not use
            cur[index] = ')';
            helper(cur, index + 1, left, right - 1, result);
        }
    }
    public static void main(String args[]) {
        AllValidParentheses test = new AllValidParentheses();
        System.out.print(test.generateParenthesis(3));
    }
}
