package basic3;

import java.util.*;

/**
 * Created by yuliu on 7/2/16.
 */
//Find all pairs of elements in a given array that sum to the given target number. Return all pairs of indices
    //A = {1,3,2,4}  target = 5, return [[0,3],[1,2]]
public class SumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //key: number    value:list of all possible indices
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);//pair
            if (indices != null) {
                for (int j : indices) {
                    result.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            //key = array[i], list = null, add
            map.get(array[i]).add(i);
            //List<Integer> list = map.get(array[i]);
            //list.add(i);

        }
        return result;
    }
    public static void main(String[] args) {
        SumAllPairI test = new SumAllPairI();
        int[] array = {1,3,2,4};
        int target = 7;
        test.allPairs(array, target);

    }
}
