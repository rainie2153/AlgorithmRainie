package LeetCode;

/**
 * Created by yuliu on 8/28/16.
 */
public class MockInterview {
    public boolean isMatch(String s, String p) {
        if ((s == null && p == null) || (s.length() == p.length())) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }

        int writeIndex = 0;
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean isFirst = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                }
            } else {
                isFirst = true;
                pattern[writeIndex++] = pattern[i];
            }
        }

        int m = str.length + 1;
        int n = writeIndex + 1;
        boolean[][] T = new boolean[m][n];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
            }
        }
        return T[str.length][writeIndex];
    }


    public static void main(String args[]) {
        MockInterview test = new MockInterview();
        System.out.print(test.isMatch("ab","*"));
    }
}
