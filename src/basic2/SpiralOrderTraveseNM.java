package basic2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 6/20/16.
 */
public class SpiralOrderTraveseNM {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;

        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;

        while (left < right && up < down) {
            for (int i = left; i <= right - 1; i++) {
                list.add(matrix[up][i]);
            }
            for (int i = up; i <= down - 1; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right; i >= left + 1; i--) {
                list.add(matrix[down][i]);
            }
            for (int i = down; i >= up + 1; i--) {
                list.add((matrix[i][left]));
            }
            left++;
            right--;
            up++;
            down--;

        }
        if (left > right || up > down) {
            return list;
        }

        //if there is only one column
        if (left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);//列不变
            }
        } else {
            for (int i = left; i <= right; i++) {
                list.add(matrix[left][i]);//行不变
            }
        }
        System.out.print(list);
        return list;

    }

    public static void main(String[] args) {
        SpiralOrderTraveseNM test = new SpiralOrderTraveseNM();
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] input = {{1}, {5}, {9}};
        test.spiral(input);
    }
}
