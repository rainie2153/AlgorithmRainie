package mianjing;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 9/26/16.
 */
public class WallsAndGates {
    //method1 DFS
//    public void wallsAndGates(int[][] rooms) {
//        for (int i = 0; i < rooms.length; i++)
//            for (int j = 0; j < rooms[0].length; j++)
//                if (rooms[i][j] == 0) {
//                    BFS(rooms, i, j, 0);
//                }
//    }
//
//    private void BFS(int[][] rooms, int i, int j, int d) {
//        //走出界的条件判断//还有room[i][j]这个条件判断可以剪纸 以前的小你就算回来visited就直接return
//        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) {
//            return;
//        }
//        rooms[i][j] = d;//d means distance also level or index
//        BFS(rooms, i - 1, j, d + 1);
//        BFS(rooms, i + 1, j, d + 1);
//        BFS(rooms, i, j - 1, d + 1);
//        BFS(rooms, i, j + 1, d + 1);
//    }
    //Method2 BFS
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
    public static void main(String[] args) {
        WallsAndGates test = new WallsAndGates();
        int[][] rooms = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        test.wallsAndGates(rooms);
    }
}
