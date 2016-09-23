package basic3;

/**
 * Created by yuliu on 7/5/16.
 */
public class LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        //record the longest common substring's start position in s
        int start = 0;
        //record the longestr comon substring's length
        int length = 0;
        int[][] common = new int[sa.length][ta.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                if (sa[i] == sa[j]) {
                    if (i == 0 || j == 0) {
                        common[i][j] = 1;
                    } else {
                        common[i][j]  = common[i - 1][j - 1] + 1;
                    }
                    if (common[i][j] > length) {
                        length = common[i][j];
                        start = i - length + 1;
                    }
                }
            }
        }
        return s.substring(start, start + length);
    }
}
