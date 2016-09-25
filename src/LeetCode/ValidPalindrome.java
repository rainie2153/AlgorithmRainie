package LeetCode;

/**
 * Created by yuliu on 9/4/16.
 * Given a string, determine if it is palindrome, considering only alphanumeric characters and ignoring cases
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
