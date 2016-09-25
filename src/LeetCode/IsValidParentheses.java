package LeetCode;

import java.util.Stack;

/**
 * Created by yuliu on 8/26/16.
 */
public class IsValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            } else if (c[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c[i] == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
