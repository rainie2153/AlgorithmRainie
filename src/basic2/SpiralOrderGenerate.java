package basic2;

/**
 * Created by yuliu on 6/20/16.
 */

//Generate an M*N 2D array in spiral order clock wise starting from the top left corner using the number of 1,2,3...M*N in increasing order
    //Assumption M and N >= 0
public class SpiralOrderGenerate {
    public int[][] spiralGenerate(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        recursiveGenerate(matrix, 0, n, 1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
        System.out.print(matrix[i][j] + " ");
        return matrix;
    }

    private void recursiveGenerate(int[][] matrix, int offset, int size, int num) {
        //base case when there is only 0 or 1 element left
        if (size == 0) {
            return;
        }
        if (size == 1) {
            matrix[offset][offset] = num;
            return;
        }

        for (int i = 0; i < size - 1; i++) {//n = 4 loop 3times1,2,3
            matrix[offset][offset + i] = num++;
        }
        for (int i = 0; i < size - 1; i++) {//loop 3 times 4,5,6
            matrix[offset + i][offset + size - 1] = num++;
        }
        for (int i = size - 1; i >= 1; i--) {
            matrix[offset + size - 1][i] = num++;
        }
        for (int i = size - 1; i >= 1; i--) {
            matrix[offset + i][offset] = num++;
        }
        recursiveGenerate(matrix, offset + 1, size - 2, num);
    }
    public static void main(String[]args) {
        SpiralOrderGenerate test = new SpiralOrderGenerate();
        int n = 4;
        test.spiralGenerate(4);
        System.out.print(test);
    }
}
