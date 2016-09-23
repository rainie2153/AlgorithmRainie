package basic2;

import java.util.Arrays;

/**
 * Created by yuliu on 6/28/16.
 */
//Given a sorted integer array. For each group of ele with the same value do not keep any of them. Do this in place
    //{1,2,2,3,3,3} -> {1}
public class ArrayDedupIII {
    public int[] dedup(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;//use flag to see if any duplicates of array[slow]


        boolean flag = false;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow]) {
                flag = true;//if duplicate do nothing
            } else if (flag == true) {//if array[fast] != array[slow] and flag is set
                //array[slow] should not be included in the valid subarray
                array[slow] = array[fast];
                flag = false;
            } else { //if not duplicate and it should be included in the valid subarray
                array[++slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, flag? slow : slow + 1);
    }
    public static void main(String[] args) {
        ArrayDedupIII test = new ArrayDedupIII();
        int[] input = {1, 2, 2, 2, 3,3};
        //System.out.print(Arrays.copyOf(input, 2));
        test.dedup(input);
    }

}
