package basic2;

import java.util.Arrays;

/**
 * Created by yuliu on 6/28/16.
 */
//Given a sorted integer array, remove duplicate ele. For each group of ele with the same value keep only one of them
    //do in place by using the left side of the original array and maintain the relative order of the ele
//{1,2,2,2,3,3} -> {1,2,3}
public class ArrayDeduplication1 {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow + 1);//return value include slow pointer
    }
}
