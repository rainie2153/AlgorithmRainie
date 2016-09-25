package LeetCode;

/**
 * Created by yuliu on 8/31/16.
 *///1.insert 2.delete 3.replace
    //Given two strings how many minimum edits(update, delete, add) is needed to convert one string to another
    //time complexity is O(m * n)
    //space complexity is O(m * n)
    // http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
// https://en.wikipedia.org/wiki/Edit_distance
public class EditDistance {
    public int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] M = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            M[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            M[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1];
                } else {
                    M[i][j] =  1 + Math.min(Math.min(M[i - 1][j- 1], M[i][j - 1]),M[i - 1][j - 1]);
                }

            }
        }
        return M[m][n];
    }

}
