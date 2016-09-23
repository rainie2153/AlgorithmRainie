package basic3;

/**
 * Created by yuliu on 7/4/16.
 */
//Given two sorted arrays of integers, find the kth smallest number
    //Assumption: The two given arrays are not null and at least one of them is not empty
    //k >= 1, k <= total lengths of the two sorted arrays
    //A = {1,4,6} B = {2,3}
public class KthSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b, int k) {
        int i = 0;
        int j = 0;
        int numChecked = 0;
        int curNUM = 0;
        if (a.length == 0) return b[k - 1];
        if (b.length == 0) return a[k - 1];
        while (i < a.length && j < b.length) {
            numChecked++;
            if (a[i] < b[j]) {
                curNUM = a[i];
                i++;
            } else {
                curNUM = b[j];
                j++;
            }
            if (numChecked == k) {
                return curNUM;
            }
        }
        if (i != a.length) {
            return a[k - numChecked + i - 1];
        } else {
            return b[k - numChecked + j - 1];
        }

    }

    public static void main(String[] args) {
        KthSmallestInTwoSortedArrays test = new KthSmallestInTwoSortedArrays();
        int[] a = {1, 3, 5, 6};
        int[] b = {2};
        System.out.print(test.kth(a, b, 5));
    }
}


