package LeetCode;

/**
 * Created by yuliu on 8/31/16.
 */
//The idea is to store states of each row int the first of that row and store states of each column in the first
    //of that column. Because the state of row0 and state of column0 would occupy the same cell. I let it be the
    //state of row0 and use another variable col0 for
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;//说明第一列为0
            }
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                matrix[i][j] = 0;
                if (col0 == 0) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
    public static void main(String args[]) {
        SetMatrixZeros test = new SetMatrixZeros();
        int[][] matrix = new int[][] {{1,2,3},{4,5,0},{3,0,9},{0,7,1}};
        test.setZeroes(matrix);
    }
}
