package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 9/5/16.
 * Given a tring s, partition s such that every substring of the partition is a palindrome
 * return all possible palindrome partioning of s
 *
 *
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        List<String> cur = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            dfs(s, 0, i, cur, res);
        }
        return res;
    }
    private void dfs(String s, int begin, int end, List<String> cur, List<List<String>> res) {
        String sub = s.substring(begin, end);
        if (end == s.length() && isPalindrome(sub)) {
            cur.add(sub);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        if(!isPalindrome(sub)) {
            return;
        }
        cur.add(sub);
        for (int i = end + 1; i <= s.length(); i++) {//后半段的DFS接着找可能性的回文
            dfs(s, end, i, cur, res);
        }
        cur.remove(cur.size() - 1);
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String args[]) {
        PalindromePartitioning test = new PalindromePartitioning();
        test.partition("aab");
    }
}
