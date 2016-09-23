package Important;

/**
 * Created by yuliu on 9/1/16.
 *///merge nums2 into nums1 as one sorted array

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
            } else if (j < 0) {
                nums1[k] = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j--];
            } else {
                nums1[k] = nums1[i--];
            }
        }
    }

    public static void main(String args[]) {
        MergeSortedArrays test = new MergeSortedArrays();
        int[] nums1 = {2,7,10,0,0,0,0,0,0,0};
        int[] nums2 = {1,8};
        test.merge(nums1, 3, nums2, 2);
        System.out.print(1 << 1);
    }
}
/*Input:
[2,0]
1
[1]
1
Output:
[2,0]
Expected:
[1,2]*/
