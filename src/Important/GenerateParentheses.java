package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 8/26/16.
 */
public class GenerateParentheses {
    public List<String> generateParentheses(int n) {
        List<String> ans = new ArrayList<>();
        char[] c = new char[n * 2];
        helper(c, 0, n, n, ans);
        return ans;
    }
    private void helper(char[] c, int index, int left, int right, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(String.valueOf(c));
            return;
        }
        if (left > 0) {
            c[index] = '(';
            helper(c, index + 1, left - 1, right, ans);
        }
        if (right > left) {
            c[index] = ')';
            helper(c, index + 1, left, right - 1, ans);
        }

    }
    public static void main(String args[]) {
        GenerateParentheses test = new GenerateParentheses();
        System.out.println(test.generateParentheses(3));
        char[] c = {'(', ')'};
        char rc = '(';
        System.out.println(Character.toString(rc));
        System.out.println(new String(c));
        System.out.println(String.valueOf(c));

    }
}
