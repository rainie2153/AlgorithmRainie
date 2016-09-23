package basic3;

/**
 * Created by yuliu on 7/5/16.
 */
//Given three string A,B and C. Determine if C can be created by merging A and B in a way that maintains the relative
    //order of the chracters in A and B.
    //None of A,B,C is null
    //C='abcde' A='acd' B='be' return true
    //C='abcde' A='adc' B='be' return false
public class InterleaveStrings {
    public boolean canMerge(String a, String b, String c) {
        int alength = a.length();
        int blength = b.length();
        int clength = c.length();
        if (alength + blength != clength) {
            return false;
        }
        boolean[][] canMerge = new boolean[alength + 1][blength + 1];
        for (int i = 0; i <= alength; i++) {
            for (int j = 0; j <= blength; j++) {
                if (i == 0 && j == 0) {
                    canMerge[i][j] = true;
                }

                if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
                    canMerge[i][j] |= canMerge[i - 1][j];
                }
                if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
                    canMerge[i][j] |= canMerge[i][j - 1];
                }
            }
        }
        return canMerge[alength][blength];
    }

    public static void main(String[] args) {
        InterleaveStrings test = new InterleaveStrings();
        String a = "acd";
        String b = "be";
        String c = "abcde";
        System.out.print(test.canMerge(a, b, c));
    }
}
