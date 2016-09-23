package Important;

import java.util.Random;

/**
 * Created by yuliu on 9/17/16.
 * Given an array of integers with possible duplicates, randomly output the index of a given target number,
 * int[] nums = new int[]{1,2,3,3,3};
 *
 */
public class RandomIndexPick {
    int[] nums;
    Random rnd;
    public RandomIndexPick(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0; // to record how many targets in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
/*
For the nth target, ++count is n. Then the probability that rnd.nextInt(++count)==0 is 1/n. Thus, the probability that return nth target is 1/n.
For (n-1)th target, the probability of returning it is (n-1)/n * 1/(n-1)= 1/n.
*/
           // int a = rnd.nextInt(++count);
            if (rnd.nextInt(++count) == 0) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3,3,3};
        RandomIndexPick test = new RandomIndexPick(nums);
        System.out.println(test.pick(3));//should return either index 2,3 or 4 randomly.Each index概率相等
        System.out.println(test.pick(1));//should return 0 since in the array only nums[0] is equal to 1

    }

}

/**
 * Your Important.Solution object will be instantiated and called as such:
 * Important.Solution obj = new Important.Solution(nums);
 * int param_1 = obj.pick(target);
 */
