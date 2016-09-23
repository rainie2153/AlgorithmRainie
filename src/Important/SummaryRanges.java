package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/27/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int prev = nums[0], start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev + 1) {
                prev += 1;
            } else if (prev == start) {
                res.add(prev + "");
                prev = nums[i];
                start = nums[i];
            } else {
                res.add(start + "->" + prev);
                prev = nums[i];
                start = nums[i];
            }
        }

        if (prev == start) {
            res.add(prev + "");
        } else {
            res.add(start + "->" + prev);
        }
        return res;
    }
    public static void main(String[] args) {
        SummaryRanges test = new SummaryRanges();
        int[] input = {1,3};
        System.out.print(test.summaryRanges(input));
    }
}
