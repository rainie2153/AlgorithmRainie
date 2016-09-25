package LeetCode;

/**
 * Created by yuliu on 9/17/16.
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pSeq = new int[nums.length];
        int[] nSeq = new int[nums.length];

        pSeq[0] = 1;
        for (int i = 1; i < len; i ++) {
            pSeq[i] = pSeq[i - 1] * nums[i - 1];
        }

        nSeq[len - 1] = 1;
        for (int i = len - 2; i >= 0; i --) {
            nSeq[i] = nSeq[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i ++) {
            pSeq[i] *= nSeq[i];
        }

        return pSeq;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currH = len - mid;
            if (citations[mid] < currH) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return len - left;
    }

    public static void main(String args[]) {
        ProductExceptSelf test = new ProductExceptSelf();
        int[] nums = {0,1,3,6,8};
        test.hIndex(nums);
    }
}
