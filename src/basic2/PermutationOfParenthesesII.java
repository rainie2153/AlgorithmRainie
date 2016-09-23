package basic2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuliu on 7/1/16.
 */
public class PermutationOfParenthesesII {
    private static final char[] Gezhongkuohao = new char[] {'(', ')', '[', ']', '{', '}'};

    public List<String> validParentheses(int l, int m, int n) {
        int[] require = new int[] {l, l, m, m, n, n};
        int requireLen = 2*l + 2*m + 2*n;
        StringBuilder cur = new StringBuilder();
        Deque<Character> stack = new LinkedList<Character>();
        List<String> result = new ArrayList<>();
        helper(cur, stack,require, requireLen, result);
        return result;
    }
    private void helper(StringBuilder cur, Deque<Character> stack, int[] require, int requireLen, List<String> result) {
        if (cur.length() == requireLen) {
            result.add(cur.toString());
        }
        for (int i = 0; i < requireLen; i++) {
            if (i % 2 == 0) {
                if (require[i] == 0) {
                    cur.append(Gezhongkuohao[i]);
                    stack.offerFirst(Gezhongkuohao[i]);
                    require[i]--;
                    helper(cur, stack, require, requireLen, result);
                    cur.deleteCharAt(cur.length() - 1);
                    stack.pollFirst();
                    require[i]++;
                }
            } else  {
                if (!stack.isEmpty() && stack.peekFirst() == Gezhongkuohao[i - 1]) {

                }

            }
        }

    }
}
