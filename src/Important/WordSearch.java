package Important;

/**
 * Created by yuliu on 8/31/16.
 *///Given a 2D board and a word, find if a word exists in the grid
    //the word can be constructed from letters of sequentially adjacent cell where "adjacent" cells are those
    //horizontally or vertically neighboring the same letter cell can not be used more than once
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int level, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if (level == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(level)) {
            return false;
        }
        visited[i][j] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            if (dfs(board, i + dx[k], j + dy[k], word, level + 1, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
    public static void main(String args[]) {
        WordSearch test = new WordSearch();
        char[][] board = {{'s','a','b'}, {'e','e','f'}};
        System.out.print(test.exist(board, "seee"));
    }
}
