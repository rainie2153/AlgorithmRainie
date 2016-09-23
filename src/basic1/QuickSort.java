package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 3/10/16.
 */
public class QuickSort {
    public int[] quickSort(int[] array) {
        if(array == null || array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivotP = partition(array, left, right);
        quickSort(array, left, pivotP - 1);
        quickSort(array, pivotP + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];

        swap(array, pivotIndex, right);//put pivot to the most right position
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < pivot){
                i++;
            } else if (array[j] >= pivot){
                j--;
            } else {
                swap (array, i++, j--);
            }
        }
        swap (array, i, right);//leftBound can be comprehend i
        return i;
    }

    //how to get the pivot by using the pivotIndex
    private int pivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] array = {1,9,8,3,5};
        array = solution.quickSort(array);
        System.out.print(Arrays.toString(array));
    }


}
