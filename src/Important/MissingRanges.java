package Important;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuliu on 9/15/16.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {//0 - 99
        List<String> res = new LinkedList<>();
        int prev = lower - 1;
        int cur;
        for (int i = 0; i < nums.length; i++) {
            cur = i == nums.length ? upper + 1 : nums[i];
            if (cur - prev > 1) {
                res.add(getRanges(prev + 1, cur - 1));
            }
            prev = cur;
        }
        return res;
    }

    private String getRanges(int from, int to) {
        return from == to ? String.valueOf(from) : from + "->" + to;
    }

    public static void main(String args[]) {
        MissingRanges test = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        print(test.findMissingRanges(nums,0,99));
        System.out.println(Math.ceil(1.0000001));
        System.out.print(Math.floor(0.999));

    }
    private static void print(List<String> res) {
        for(String each : res) {
            System.out.println(each);
        }
    }
}
