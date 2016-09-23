package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 5/27/16.
 */
public class SelectionSortLai {

        public int[] selection(int a[], int n) {
            int minindex, temp;
            for (int i = 0; i < n - 1; i++) {
                minindex = i;
                for (int j = i + 1; j < n; j++) {
                    if (a[minindex] > a[j]) {
                        minindex = j;
                    }
                }
                temp = a[i];
                a[i] = a[minindex];
                a[minindex] = temp;
            }
            return a;
        }





        public static void main(String[] args) {
            SelectionSortLai solution = new SelectionSortLai();
            int[] array = {1,9,8,3,5};
            array = solution.selection(array, 5);
            System.out.print(Arrays.toString(array));
        }
    }

