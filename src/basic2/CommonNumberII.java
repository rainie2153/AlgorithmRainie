package basic2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 6/19/16.
 */
public class CommonNumberII {
    public List<Integer> common (int[] a, int[] b) {
        List<Integer> common = new ArrayList<Integer>();
        HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>();
        for (int num: a) {
            Integer ct = countA.get(num);//num is key and we wanna get how many 1 is there
            if (ct != null) {
                countA.put(num, ct+1);
            } else {
                countA.put(num, 1);
            }
        }
        HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>();
        for (int num : b) {
            Integer ct = countB.get(num);
            if (ct != null) {
                countB.put(num, ct + 1);
            } else {
                countB.put(num, 1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
            Integer ctInB = countB.get(entry.getKey());
            if (ctInB != null) {
                int Binsidehas = Math.min(entry.getValue(), ctInB);
                for (int i = 0; i < Binsidehas; i++) {
                    common.add(entry.getKey());
                }
            }
        } return common;

    }
    public static void main (String[] args) {
        CommonNumber test = new CommonNumber();
        int[] a = {1, 1, 2, 2, 3};
        int[] b = {1, 1, 2, 5, 6};
        test.common(a, b);
    }
}
