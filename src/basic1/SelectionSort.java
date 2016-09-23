package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 5/27/16.
 */
public class SelectionSort {
    public int[] selection(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
                }
            } return a;
    }

    private void swap(int a[], int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }


    public static void main(String[] args) {
        SelectionSort solution = new SelectionSort();
        int[] array = {1,9,8,3,5};
        array = solution.selection(array, 5);
        System.out.print(Arrays.toString(array));
    }
}

