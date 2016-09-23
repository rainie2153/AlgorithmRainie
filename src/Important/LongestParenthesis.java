package Important;

/**
 * Created by yuliu on 8/27/16.
 */
public class LongestParenthesis {
//    public int longestValidParentheses(String s) {
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(-1);
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ')'
//                    && stack.peek() != -1
//                    && s.charAt(stack.peek()) == '(') {
//                stack.pop();
//                max = Math.max(max, i - stack.peek());
//            } else {
//                stack.push(i);
//            }
//        }
//        return max;
//    }
    public int longestValidParentheses(String s) {
        int[] M = new int[s.length()];
        int leftCount = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                M[i] = M[i - 1] + 2;
                M[i] += (i - M[i] >= 0) ? M[i - M[i]] : 0;
                max = Math.max(M[i], max);
                leftCount--;
            }
        }
        return max;
    }
    public static void main(String args[]) {
        LongestParenthesis test = new LongestParenthesis();
        String s = "((())";
        System.out.print(test.longestValidParentheses(s));
    }
}
