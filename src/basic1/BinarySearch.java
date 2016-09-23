package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 3/11/16.
 */
public class BinarySearch {
    public int bs(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int target = 7;
        int[] array = {1, 2, 3, 4, 6, 7, 9};
        System.out.println(Arrays.toString(array));

        System.out.println(solution.bs(array, target));
    }
}
