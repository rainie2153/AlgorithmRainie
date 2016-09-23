package basic2;

/**
 * Created by yuliu on 6/29/16.
 */
//move 0s to the right end of the array, the relative order of ele
public class Move0sToEndII {
    public int[] moveZero(int[] array) {
        if(array.length <= 1) {
            return array;
        }
        int slow = 0;//slow pointer is not included in the non-zero subarray
        for (int fast = 0; fast < array.length; fast++) {
            if(array[fast] != 0) {
                array[slow++] = array[fast];
            }
        }
        for (int fast = slow; fast < array.length; fast++) {
            array[fast] = 0;
        }
        return array;
    }

}
