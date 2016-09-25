package LeetCode;

/**
 * Created by yuliu on 8/24/16.
 */
public class MedianOfTwoSortedArray {
    public double findMedian(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (double) (findKthSmallest(nums1, 0, nums2, 0, totalLength / 2) + findKthSmallest(nums1, 0, nums2, 0, totalLength / 2 + 1)) / 2;
        } else {
            return (double) findKthSmallest(nums1, 0, nums2, 0, totalLength / 2 + 1);
        }

    }
    //find kth smallest number in two sorted arrays
    private int findKthSmallest(int[] nums1, int left1, int[] nums2, int left2, int k) {
        if (left1 >= nums1.length) {
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length) {
            return nums1[left1 + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        int mid1 = left1 + k / 2 - 1;
        int mid2 = left2 + k / 2 - 1;

        int candidate1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        int candidate2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];

        if (candidate1 <= candidate2) {
            return findKthSmallest(nums1, mid1 + 1, nums2, left2, k - k / 2);
        } else {
            return findKthSmallest(nums1, left1, nums2, mid2 + 1, k - k / 2);
        }
    }
    public static void main(String args[]) {
        MedianOfTwoSortedArray test = new MedianOfTwoSortedArray();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        test.findMedian(nums1, nums2);
    }
}

