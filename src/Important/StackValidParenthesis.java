package Important;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 7/15/16.
 */
public class StackValidParenthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(' ) stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{' ) stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[' ) stack.pop();

            else
                return false;

        }
        return stack.isEmpty();
    }
    public static void main(String args[]) {
        StackValidParenthesis test = new StackValidParenthesis();
        System.out.print(test.isValid("()[]{}"));
    }
}
