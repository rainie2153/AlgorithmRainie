package Important;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 9/6/16.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int one = stack.pop();
                int two = stack.pop();
                stack.push(one + two);
            } else if (token.equals("-")) {
                int one = stack.pop();
                int two = stack.pop();
                stack.push(two - one);
            } else if (token.equals("*")) {
                int one = stack.pop();
                int two = stack.pop();
                stack.push(one * two);
            } else if (token.equals("/")) {
                int one = stack.pop();
                int two = stack.pop();
                stack.push(two / one);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
    public static void main(String args[]) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.print(test.evalRPN(tokens));
    }
}
