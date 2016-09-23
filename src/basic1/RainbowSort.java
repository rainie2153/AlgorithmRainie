package basic1;

import java.util.Arrays;

/**
 * Created by yuliu on 3/10/16.
 *///Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent
    //with the colors int the order red, white and blue.
    //idea就是用counting sort
    //First, iterate the array counting number of 0's , 1's and 2's then overwrite array with
    //total number of 0's then 1's and followed by 2's
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length <= 1) {
           return array;
        }
        int i = 0;//i++
        int j = 0;//j++
        int k = array.length - 1;//k--相向 同向
        while (j <= k) {//-1-1-1-10000000XXXXXXXX111111
            if (array[j] == -1 ) {
                swap(array, i++, j++);
            } else if (array[j] == 0) {
                j++;
            } else {
                swap(array, j, k--);
            }
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
        RainbowSort solution = new RainbowSort();
        array = solution.rainbowSort(array);
        System.out.println(Arrays.toString(array));
    }
}
