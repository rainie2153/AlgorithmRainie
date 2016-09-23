package basic3;

/**
 * Created by yuliu on 7/5/16.
 */
public class LongestCommonSubsequence {
    public int longest(String s, String t) {
        int[][] length = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                } else {
                    length[i][j] = Math.max(length[i - 1][i], length[i][j - 1]);
                }
            }
        }
        return length[s.length()][t.length()];
    }
}
