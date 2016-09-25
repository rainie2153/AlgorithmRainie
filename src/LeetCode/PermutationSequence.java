package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/18/16.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer>  num = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) {
            factor[i] = i * factor[i - 1];
        }
        k--;
        for (int i = n - 1;
             i >= 0;
             i--) {
            int index = k / factor[i];
            k = k % factor[i];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.print(test.getPermutation(4, 9));
        System.out.print("a" + "nima"+"@@@#");
    }
}
