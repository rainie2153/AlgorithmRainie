package basic2;

import java.util.Arrays;

/**
 * Created by yuliu on 6/29/16.
 */
//Unsorted array, repeatedly deduplication//消连连看{1,2,3,3,3,2,2} -> {1,2,2,2} -> {1]
public class ArrayDedupIV {
    public int[] dedup(int[] array) {
        int slow = -1;
        for (int fast = 0; fast < array.length; fast++) {
            //we are using left part of the original array as stack
            //top element's index is slow. if the stack is empty, slow == -1
            //push the element of the stack, we can push the ele into the stack as well
            if (slow == -1 || array[slow] != array[fast]) {//stack is empty or no depud
                array[++slow] = array[fast];//stack++ and ...
            } else {
                //ignore all consecutive duplicate and remove the top ele of stack
                while (fast + 1 < array.length && array[fast + 1] == array[slow]) {
                    fast++;
                }
                slow--;
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
    public static void main(String[] args) {
        ArrayDedupIV test = new ArrayDedupIV();
        int[] input = {1, 2, 3,3,3, 2};
        int[] output = test.dedup(input);
    }
}
