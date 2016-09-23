package basic3;

/**
 * Created by yuliu on 7/4/16.
 */
//O(logk)
public class KthSmallestInTwoSortedArraysRecursion {
    public int kth(int[]a, int[] b, int k) {
        return helper(a, 0, b, 0, k);
    }
    private int helper(int[] a, int i, int[] b, int j, int k) {
        if (i >= a.length) {
            return b[j - 1 + k];
        }
        if (j >= b.length) {
            return a[i - 1 + k];
        }
        if (k == 1) {
            return Math.min(a[i], b[j]);
        }
        int amid = i + k / 2 - 1;
        int bmid = j + k / 2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if (aval <= bval) {
            return helper(a, amid + 1, b, j, k - k / 2);
        } else {
            return helper(a, i, b, bmid + 1, k - k / 2);
        }
    }
    public static void main(String[] args) {
        KthSmallestInTwoSortedArrays test = new KthSmallestInTwoSortedArrays();
        int[] a = {1, 3, 5, 6};
        int[] b = {2};
        System.out.print(test.kth(a, b, 5));
    }
}