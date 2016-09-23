package basic3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 7/2/16.
 */
public class FourSumHashMap {
    static class Pair {
        int left;
        int right;
        public Pair (int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public boolean exist(int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[j] + array[i];
                if(map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) {//j store small index
                    return true;
                }
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(j, i));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FourSum test = new FourSum();
        int[] array = {2, 2, 2, 2, 5};
        int target = 8;
        test.exist(array, target);
        System.out.print(test.exist(array, target));
    }
}
