package basic3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuliu on 7/2/16.
 */
//Determine if there exists three elements in a given array that sum to the given target number
    //Return all the triple of values that sums to target
    //A = {1,2,3,3,2,4} target = 8  return [[1,3,4],[2,2,4]]
public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;//ignore all duplicated element after the first one.
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int tmp = array[left] + array[right];
                if (tmp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;

                    while (left < right && array[left] == array[left - 1]) {
                        left++;//ignore all possible dup j as well
                    }
                } else if (tmp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return result;
    }


    public static void main(String args[]) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        test.allTriples(nums, 0);
    }
}
