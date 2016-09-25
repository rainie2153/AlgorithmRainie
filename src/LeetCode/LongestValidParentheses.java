package LeetCode;

/**
 * Created by yuliu on 7/16/16.
 */
/*My solution uses DP. The main idea is as follows: I construct a array longest for any longest[i], it stores the longest length of valid parentheses which
* is end at i. And the DP idea is
* case 1    if s.charAt(i) is '('  set longest[i] to 0 because any string with '(' cannot be a valid one
* case2    if s[i] is ')' if s.charAt(i - 1) is '('  longest[i] = longest[i - 2] + 2
 * case3    s.charAt(i - 1) is ')' and  s.charAt(i - longest[i - 1] - 1) == '(' 那么 longest[i] = longest[i - 1] + 2 + longest[i - longest[i-1]-2]*/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] M = new int[s.length()];
        int leftCount = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                M[i] = M[i - 1] + 2;//M[i] represent from 0 to i how many valid parentheses
                M[i] += ((i - M[i] >= 0) ? M[i - M[i]] : 0);//i - M[i] how many parenth left not matched yet totally
                //flag=true M[i] + M[i - M[i]]
                max = Math.max(M[i], max);
                leftCount--;
            }
        }
        return max;
    }
    public static void main(String args[]) {
        LongestValidParentheses test = new LongestValidParentheses();
        test.longestValidParentheses("((()((())");//{0,0,0,2,0,2}   i=3
    }
}
