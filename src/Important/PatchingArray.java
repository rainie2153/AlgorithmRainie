package Important;

/**
 * Created by yuliu on 8/3/16.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long max = 0;
        int cnt = 0;
        for (int i = 0; max < n;) {
            if (i >= nums.length || max < nums[i] - 1) {
                max += max + 1;
                cnt++;
            } else {
                max += nums[i];
                i++;
            }
        }
        return cnt;
    }
    public static void main(String args[]) {
        PatchingArray test = new PatchingArray();
        int[] input = {1,5,10};
        System.out.print(test.minPatches(input, 20));
    }
}

