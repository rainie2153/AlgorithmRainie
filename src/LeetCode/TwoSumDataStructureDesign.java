package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 9/15/16.
 */
public class TwoSumDataStructureDesign {
    List<Integer> res = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public void add(int number) {
        res.add(number);
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (int i : res) {
            int j = value - i;
            if (i == j && map.get(i) > 1 || i != j && map.containsKey(j)) {
                return true;
            }
        }
        return false;
    }
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
    public static void main(String arg[]) {
        TwoSumDataStructureDesign test = new TwoSumDataStructureDesign();
        test.add(1);
        test.add(1);
        System.out.print(test.trailingZeroes(6));
        System.out.print(test.find(2));
    }
}
