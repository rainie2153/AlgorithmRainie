package Important;

/**
 * Created by yuliu on 8/29/16.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int left = 0;
        int right = n -1;
        int up = 0;
        int down = n - 1;
        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int temp = matrix[up][left + i];
                matrix[up][left + i] = matrix[up + i][right];
                matrix[up + 1][right] = matrix[down][right - i];
                matrix[right - i][down] = temp;
            }
            left++;
            right--;
            up++;
            down--;
        }
    }

}
