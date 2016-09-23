package Important;

/**
 * Created by yuliu on 8/25/16.
 *///s means string , p means pattern
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s == null && p == null) {
            return true;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] M = new boolean[s.length() + 1][p.length() + 1];
        M[0][0] = true;

        for (int j = 1; j < M[0].length; j++) {
            if (pattern[j - 1] == '*') {
                M[0][j] = M[0][j - 2];
            }
        }
        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) {
                    M[i][j] = M[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    M[i][j] = M[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == str[i - 1]) {
                        M[i][j] = M[i - 1][j] || M[i][j];
                    }
                } else M[i][j] = false;
            }
        }
        return M[s.length()][p.length()];
    }
    public static void main (String args[]) {
        RegularExpressionMatching test = new RegularExpressionMatching();
//        System.out.println(test.isMatch("aa","a"));
//        System.out.println(test.isMatch("aaa","aa"));
//        System.out.println(test.isMatch("aa","aa"));
//        System.out.println(test.isMatch("aa", "a*"));
//        System.out.println(test.isMatch("ab", ".*"));
//        System.out.println(test.isMatch("aab", "c*a*b"));
        System.out.println(test.isMatch("aaa", "ab*a*c*a"));


    }
}
