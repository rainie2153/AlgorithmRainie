package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 3/10/16.
 */
public class MergeSort {
    public int[] mergesort(int[] array) {
        if(array == null || array.length <= 1) {
            return array;
        }
        int[] helper = new int[array.length];
        wtf(array, helper, 0, array.length -1);
        return array;
    }

    public void wtf (int[] array, int[] helper, int left, int right) {

        if(left > right) {
            return;
        }

        int mid = left + (right - left) / 2;
        wtf(array, helper, left, mid);
        wtf(array, helper, mid+1, right);

        combination(array, helper, left, mid, right);
        return;
    }

    public void combination(int[] array, int[] helper, int left, int mid, int right) {
        for(int i = left; i<= right; i++) {
            helper[i] = array [i];
        }
        int leftindex = left;
        int rightindex = mid + 1;
        while(leftindex <= mid && rightindex <= right) {
            if(helper[leftindex] <= helper[rightindex]) {
                array[left++] = helper[leftindex++];
            }else {
                array[left++] = helper[rightindex++];
            }
        }
        while(leftindex <= mid) {
            array[left++] = helper[leftindex++];
        }
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();

        int[] array = {1,4,5,2,3,7,8,6} ;
        System.out.println(Arrays.toString(array));
        array = solution.mergesort(array);
        System.out.println(Arrays.toString(array));
    }
}
