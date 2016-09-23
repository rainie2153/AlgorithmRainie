package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 3/11/16.
 */
public class twoDBinarySearch {
    //it is like map 2D to 1D by math
    public int[] search(int[][] matrix, int target) {

        int[] result = new int[2];
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (matrix[mid / col][mid % col] < target) {
                    start = mid + 1;
            } else if (matrix[mid / col][mid % col] > target) {
                    end = mid - 1;
            } else {
                    result[0] = mid / col;
                    result[1] = mid % col;
                    return result;
                }

        }

        result[0] = -1;
        result[1] = -1;
        return result;
    }


    public static void main(String[] args) {
        twoDBinarySearch search = new twoDBinarySearch();
        int[][] a = {{1}, {4}, {8}, {11}};
        int target = 7;

        System.out.print(Arrays.toString(search.search(a, target)));
    }

}

