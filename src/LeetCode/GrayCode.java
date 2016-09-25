package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuliu on 9/1/16.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
    public static void main(String args[]) {
        GrayCode test = new GrayCode();
        test.grayCode(3);
        int a = 0 >> 1;
        int b = 0 ^ (0 >> 1);
    }

}
