package LeetCode;

/**
 * Created by yuliu on 8/24/16.
 */
public class LongestPalindromicSubstring5 {
    private int maxLen = 0;
    private int lo = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);// odd length
            extendPalindrome(s, i, i + 1);//even length
        }
        return s.substring(lo, lo + maxLen);
    }
    private void extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            lo = i + 1;
            maxLen = j - i - 1;
        }
    }
    public static void main(String args[]) {
        LongestPalindromicSubstring5 test = new LongestPalindromicSubstring5();
        String s = "aba";
        System.out.print(test.longestPalindrome(s));
    }
}
