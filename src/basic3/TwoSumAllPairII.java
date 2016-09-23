package basic3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuliu on 7/2/16.
 */
//Find all pairs of elements in a given array that sum of the pair the given target number. Return all distinct pairs of values
    //The given array is not null and has length of at least 2
    //The order of the values in the pair does not matter
    //A = {2,1,3,2,4,3,4,2}  target = 6, return [[2,4],[3,3]]
public class TwoSumAllPairII {
    public List<List<Integer>> allPairs (int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) { //ignore all consecutive duplicate values
            if (left > 0 && array[left] == array[left - 1]) {
                left++;
                continue;
            }
            int cur = array[left] + array[right];
            if (cur == target) {
                result.add(Arrays.asList(array[left], array[right]));
                left++;
                right--;
            } else if (cur < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }



}
