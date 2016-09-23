package basic2;

import java.util.Arrays;

/**
 * Created by yuliu on 6/28/16.
 */
//sorted array, duplicate ele only retain two
    //{1,2,2,2,3,3,3} -> {1,2,2,3,3}
public class ArrayDeduplicationII {
    public int[] depup(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int slow = 1;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                array[++slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow + 1);//include
    }
    public static void main(String[] args) {
        ArrayDeduplicationII test = new ArrayDeduplicationII();
        int[] input = {1,3,4,2,3,3,3};
        test.depup(input);
        //System.out.print(test);

    }

}
