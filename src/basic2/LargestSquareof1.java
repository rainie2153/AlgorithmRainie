package basic2;

/**
 * Created by yuliu on 6/27/16.
 */
public class LargestSquareof1 {
    public int largest(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int result = 0;
        //dp[i][j]means the largest square of 1's with right bottom corner as matrix[i][j]
        int[][]largest = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <  N; j++) {
                if (i == 0 || j == 0) {
                    largest[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.min(largest[i][j - 1] + 1, largest[i - 1][j] + 1);
                    largest[i][j] = Math.min(largest[i - 1][j - 1] + 1, largest[i][j]);
                }
                result = Math.max(result, largest[i][j]);
            }

        }
        return result;
    }
}
