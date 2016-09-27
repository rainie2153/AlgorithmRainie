package mianjing;
import java.util.*;
/**
 * Created by yuliu on 9/26/16.
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int count  = 0;
        if(grid == null ||grid.length == 0) {
            return count;
        }

        int m = grid.length;
        int n = grid[0].length;
        int i = 0, j = 0;
        int imax = 0, jmax = 0;
        //bfs explore the map
        HashSet<Pair> set = new HashSet<Pair>();// mark all 1 in the grid
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    BFS(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    class Pair{
        int x, y;
        public Pair(int i, int j){
            this.x = i;
            this.y = j;
        }
    }
    private void BFS(int i, int j ,char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        //use as start to explore the grid
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(i, j));
        grid[i][j] = '#';// mark as visited
        while(q.size() > 0){
            Pair cur = q.poll();

            if(cur.y + 1 < n && grid[cur.x][cur.y + 1] == '1'){
                q.offer(new Pair(cur.x, cur.y + 1));
                grid[cur.x][cur.y + 1] = '#';
            }
            if(cur.y - 1 >= 0 && grid[cur.x][cur.y - 1] == '1'){
                q.offer(new Pair(cur.x, cur.y -1));
                grid[cur.x][cur.y - 1] = '#';
            }
            if(cur.x - 1 >= 0 && grid[cur.x -1][cur.y] == '1'){
                q.offer(new Pair(cur.x - 1, cur.y));
                grid[cur.x -1][cur.y] = '#';
            }
            if(cur.x + 1 < m && grid[cur.x + 1][cur.y] == '1'){
                q.offer(new Pair(cur.x + 1, cur.y));
                grid[cur.x + 1][cur.y ] = '#';
            }
        }
    }
}
