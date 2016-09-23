package Important;

/**
 * Created by yuliu on 8/4/16.
 */
public class CreateMaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int n = nums1.length;
        int m = nums2.length;
        //pick i items from nums1
        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, res, 0, 0)) res = candidate;
        }
        return res;
    }

    //first create int[k] with one array
    public int[] maxArray(int[] num, int k) {
        int n = num.length;
        int[] res = new int[k];//simulates a stack
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + (n - i) > k && j > 0 && res[j - 1] < num[i]) j--;
            if (j < k) res[j++] = num[i]; //push into stack
        }
        return res;
    }

    //check if nums1 is greater than nums2
    public boolean greater(int[] nums1, int[] nums2, int i, int j) {
        int n = nums1.length, m = nums2.length;
        while (i < n && j < m && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == m || (i < n && nums1[i] > nums2[j]);
    }

    //merge two arrays
    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int r = 0;
        int i = 0, j = 0;
        while (r < k) {
            res[r++] = greater(nums1, nums2, i, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        CreateMaxNumber test = new CreateMaxNumber();
        int[] nums1 = {3, 4, 6, 5, 7, 1};
        int[] nums2 = {9, 1};

        test.maxNumber(nums1, nums2, 5);
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res += i *10;
            System.out.println(res);
        }
    }
}
