package Important;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuliu on 9/5/16.
 * Given a 2D board containing X and O, capture all regions surrounded by X
 * A region is captured by flipping all 0 to X in that surrounded region
 *
 * 跟number of islands类似，only the cells on the borders can not be surrounded.
 * 所以先找出所有边缘上面的O 把Omark成whatever比如＃  然后再scan 内部的所有O 然后把内部所有的O替换成X
 */

//Method 1. DFS 这个方法test case大一些的话会stack over flow,because for large board, too many method calls are pushed to stack and cause sof
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;//4
        int n = board[0].length;//6

        for (int i = 0; i < m; i++) {//先check竖着的最左边那个边
            if (board[i][0] == 'O') {
                mark(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {//然后竖着的最右边的那个边
                mark(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {//top 横着的行
            if (board[0][j] == 'O') {
                mark(board, 0, j);
            }
            if(board[m - 1][j] == 'O') {//bottom 横着的行
                mark(board, m - 1, j);
            }
        }

        //把面包4个边的O都替换成＃
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';//再变回来O
                }
            }
        }
    }

    private void mark(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        mark(board, i - 1, j);
        mark(board, i + 1, j);
        mark(board, i, j - 1);
        mark(board, i, j + 1);
        /*Input:
["OOO","OOO","OOO"]
Output:
["OOO","OXO","OOO"]
Expected:
["OOO","OOO","OOO"]*/
        /*如果没有上面这四句的DFS就会报错 因为如果有另外一个内部的O与边上的O相连的话 那么他不可能被XXX包围了*/


    }

    // method 2. BFS
    public void solve2(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;//行数
        int n = board[0].length;//列数

        for (int i = 0; i < m; i++) {//先check竖着的最左边那个边
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {//然后竖着的最右边的那个边
                bfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {//top 横着的行
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if(board[m - 1][j] == 'O') {//bottom 横着的行
                bfs(board, m - 1, j);
            }
        }

        //把面包4个边的O都替换成＃
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';//再变回来O
                }
            }
        }

    }
    //前面都一样 主要是看后面这个BFS的函数
    private void bfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        int index = i * n + j;

        Queue<Integer> q = new LinkedList<>();
        q.offer(index);

        board[i][j] = '#';

        while(!q.isEmpty()) {
            int top = q.poll();
            int row = top / n;//i
            int col = top % n;//j

            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '#';
                q.offer((row - 1) * n + col);
            }
            if (row + 1 < m && board[row + 1][col] == 'O'){
                board[row + 1][j] = '#';
                q.offer((row + 1) * n + col);
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'O'){
                board[row][col - 1] = '#';
                q.offer(row * n + col - 1);
            }
            if (col + 1 < n && board[row][col + 1]=='O'){
                board[row][col + 1]='#';
                q.offer(row * n + col + 1);
            }

        }
    }
    public static void main(String args[]) {
        SurroundedRegions test = new SurroundedRegions();
//        char[][] board = {{'X','X','X','X','X'},
//                            {'O','O','X','O','X'},
//                             {'O','O','X','X','X'},
//                             };
        char[][] board = {{'O','O'},{'O','O'}};
        test.solve2(board);
        /*["OXOOOOOOO","OOOXOOOOX","OXOXOOOOX","OOOOXOOOO","XOOOOOOOX","XXOOXOXOX","OOOXOOOOO","OOOXOOOOO","OOOOOXXOO"]*/
    }
/*debug出来发现不能用＃  用1 就可以work 什么鬼*/
}
