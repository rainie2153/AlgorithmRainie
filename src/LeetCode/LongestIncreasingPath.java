package LeetCode;

/**
 * Created by yuliu on 8/3/16.
 */
public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int currMax = 1;
        int[][] step = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (step[i][j] == 0) currMax = Math.max(currMax, dfs(matrix, i, j, step));
            }
        }
        return currMax;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] step) {
        int n = matrix.length, m = matrix[0].length;
        if (step[i][j] != 0) return step[i][j];
        int max = 1;
        if (i > 0 && matrix[i - 1][j] < matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i - 1, j, step));
        }
        if (i < n - 1 && matrix[i + 1][j] < matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i + 1, j, step));
        }
        if (j > 0 && matrix[i][j - 1] < matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i, j - 1, step));
        }
        if (j < m - 1 && matrix[i][j + 1] < matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i, j + 1, step));
        }
        step[i][j] = max;
        return max;
    }

    public static void main (String[] args) {
        LongestIncreasingPath test = new LongestIncreasingPath();
        int[][] input =   {{9,9,4},
                {6,6,8},
                {2,1,1}};
        System.out.print(test.longestIncreasingPath(input));
    }
}
