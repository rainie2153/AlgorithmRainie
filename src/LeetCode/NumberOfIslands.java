package LeetCode;

/**
 * Created by yuliu on 9/15/16.
 * The problem can be solved by applying DFS() in each component. In each DFS() call, a component or a sub graph is
 * visited, we will call DFS on the next un visteted component. The number of calls to DFS() gives the number of
 * connected components.
 */
public class NumberOfIslands {
    public int numIsland(char[][] grid) {
        int count = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m) {
            return;//出界
        }
        if(visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
    public static void main (String[] args) {

        char M[][]=  new char[][] { {'1', '1', '0', '0','0' },
                                    {'0', '1', '0', '0', '1'},
                                    {'1', '0', '0', '1', '1'},
                                    {'0', '0', '0', '0', '0'},
                                    {'1', '0', '1', '0', '1'}
        };
        NumberOfIslands I = new NumberOfIslands();
        System.out.println("Number of islands is: "+ I.numIsland(M));
    }
}
