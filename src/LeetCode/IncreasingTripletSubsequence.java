package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuliu on 8/3/16.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2) return false;
        //keep a stack of size 3
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            insert(res, target);
            if (res.size() == 3) return true;
        }
        return false;

    }

    public void insert(List<Integer> res, int target) {
        if (res.size() == 0 || target > res.get(res.size() - 1)) {
            res.add(target);
            return;
        }
        //find the smallest element that is larget than target
        int i = res.size() - 1;
        while (i >= 0 && res.get(i) >= target) {
            i--;
        }
        res.set(i + 1, target);
    }
    public static void main(String args[]) {
        IncreasingTripletSubsequence test = new IncreasingTripletSubsequence();
        int[] input = {5,2,3,1,4};
        System.out.print(test.increasingTriplet(input));
    }
}
