package basic2;



import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuliu on 3/16/16.
 */
public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {

        int row = matrix.length;
        int col = matrix [0].length;

        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {

                if (c1.value == c2.value) return 0;
                //if (c1.equals(c2)) return 0;    c1  c2 代表的不是一个值 所以取值要c1.value
                return c1.value < c2.value ? -1: 1;
            }
        });
        boolean [][] visited = new boolean[row][col];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited [0][0] = true;

        int result = 0;

        for (int i = 0; i < k - 1; ++i) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < row && !visited[cur.row + 1][cur.col] ) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col +1 < col && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col+1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return minHeap.peek().value;



    }


    static class Cell{
        int row;
        int col;
        int value;

        Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }



    public static void main(String[] args) {
        KthSmallestInSortedMatrix test = new KthSmallestInSortedMatrix();
        int [][] input = { {1,  3,   5,  7},

                {2,  4,   8,   9},

                {3,  5, 11, 15}};
        int result = test.kthSmallest(input, 4);
        System.out.print(result);
    }
}
