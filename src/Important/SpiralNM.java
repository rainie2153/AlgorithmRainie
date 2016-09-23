package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/18/16.
 */
public class SpiralNM {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) return res;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;//列
        int up = 0;
        int down  = row - 1;//行

        while (left < right && up < down) {
            for (int i = left; i < right; i++) {
                res.add(matrix[up][i]);//left -> right
            }
            for (int i = up; i < down; i++) {
                res.add(matrix[i][right]);//up -> down
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[down][i]);//right -> left
            }
            for (int i = down; i > up; i--) {
                res.add(matrix[i][left]);//down -> up
            }
            left++;
            right--;
            up++;
            down--;
        }
        if (left > right || up > down) {
            return res;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][left]);
            }
        } else if (up == down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
        }
        return res;
    }
    public static void main(String args[]) {
        SpiralNM test = new SpiralNM();
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(test.spiralOrder(input));
    }

}
