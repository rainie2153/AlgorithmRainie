package Important;

/**
 * Created by yuliu on 7/20/16.
 */
public class MergeSortedList {
    public void merge (int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
            } else if (j < 0) {
                nums1[k] = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j--];
            } else nums1[k] = nums1[i--];
        }

    }

    public static void main (String[] args) {
        MergeSortedList test = new MergeSortedList();
        int[] input = new int[]{1,5,6,7};
        int[] input2 = new int[]{2,3,4};
        test.merge(input,3,input2,3);
    }
}
