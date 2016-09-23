package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 3/11/16.
 */
public class KClosest {
    public int[] KClosest(int[] array, int target, int k) {
        if(array == null || array.length == 0 ) return array;
        if (k == 0) return new int[0];

        int left =  step1(array, target);
        int right = left + 1;//相连
        int[] output = new int[k];

        for (int i = 0; i < k; i++) {
            if (right > array.length - 1 || left >= 0
                    && target - array[left] <= array[right] - target) {
                output[i] = array[left--];
            }else {output[i] = array[right++];}

            }
        return output;
    }




    private int step1(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid;
            } else return mid;
        }
        if (Math.abs(array[left] - target) < Math.abs(array[right] - target) ) {
            return left;
        } else return right;

    }



    public static void main(String[] args) {
        KClosest fs = new KClosest();
        int[] array = {2, 2};
        int target = 0;
        int k = 0;
        System.out.print(Arrays.toString(fs.KClosest(array, target, k)));
    }
}

