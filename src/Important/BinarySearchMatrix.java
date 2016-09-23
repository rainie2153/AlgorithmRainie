package Important;

/**
 * Created by yuliu on 7/28/16.
 */
public class BinarySearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0  ) return false;
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        while (col >= 0 && row <= n - 1) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        BinarySearchMatrix test = new BinarySearchMatrix();
        int[][] nums = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
                };
        test.searchMatrix(nums, 9);
    }

}
