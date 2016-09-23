package basic2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 6/19/16.
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        recusiveTraverse(matrix, 0, matrix.length, list);
        System.out.print(list);
        return list;
    }

    private void recusiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }

        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + i][offset + size - 1]);
        }

        for (int i = size - 1; i >=1; i--) {
            result.add(matrix[offset + size -1][offset + i]);
        }

        for (int i = size - 1; i >= 1; i--) {
            result.add(matrix[offset + i][offset]);
        }

        recusiveTraverse(matrix, offset + 1, size - 2, result);

    }
    public static void main(String[] args) {
        SpiralOrderTraverseI test = new SpiralOrderTraverseI();
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        test.spiral(input);
        //System.out.print(test);
    }
}
