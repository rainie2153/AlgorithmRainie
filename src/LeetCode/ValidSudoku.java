package LeetCode;

/**
 * Created by yuliu on 8/28/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, 0, 8, i, i)) {
                return false;
            }
            if (!isValid(board, i, i, 0, 8)) {
                return false;
            }
            if (!isValid(board, 3 * (i % 3), 3 * (i % 3) + 2, 3 * (i / 3), 3 * (i / 3) + 2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int left, int right, int up, int down) {
        boolean[] visited = new boolean[9];
        for (int i = left; i <= right; i++) {
            for (int j = up; j <= down; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = board[i][j] - '1';
                if (visited[k]) {
                    return false;
                } else {
                    visited[k] = true;
                }
            }
        }
        return true;
    }
    public static void main(String args[]) {
        ValidSudoku test = new ValidSudoku();
        char[][] c = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        test.isValidSudoku(c);
    }
}
