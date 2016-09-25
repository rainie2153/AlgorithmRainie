package LeetCode;

/**
 * Created by yuliu on 7/27/16.
 */
public class FindKthLargestEleArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    public int quickSelect(int[] nums, int k, int left, int right) {
        if (left == right) return nums[left];
        int position = partition(nums, left, right);
        if (position == k - 1) return nums[k - 1];
        else if (position < k - 1) return quickSelect(nums, k, position + 1, right);
        else return quickSelect(nums, k, left, position - 1);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] > pivot) {
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        FindKthLargestEleArray test = new FindKthLargestEleArray();
        int[] input = {3,2,1,5,6,4};
        System.out.print(test.findKthLargest(input, 3));
    }
}
