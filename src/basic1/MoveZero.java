package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 3/10/16.
 */
public class MoveZero {
    public int[] movezero(int[] array){
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] == 0) {
                swap (array, j, k--);
            } else j++;
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {0,1,-1,0,1,1,-1};
        MoveZero solution = new MoveZero();
        array = solution.movezero(array);
        System.out.println(Arrays.toString(array));
    }
}
