package Important;

/**
 * Created by yuliu on 9/16/16.
 */
public class KthLargest215interview {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    public int quickSelect(int[] nums, int k, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int Pivotpos = partition(nums, left, right);

        if (Pivotpos == k - 1) {
            return nums[k - 1];
        }
        else if (Pivotpos < k - 1) {
            return quickSelect(nums, k, Pivotpos + 1, right);
        }else {
            return quickSelect(nums, k, left, Pivotpos - 1);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int l = left;
        int r = right - 1;
        while (l <= r) {
            if (nums[l] > pivot) {
                l++;
            } else if (nums[r] <= pivot){
                r--;
            } else {
                swap(nums, l++, r--);
            }
        }
        swap(nums, l, right);
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        KthLargest215interview test = new KthLargest215interview();
        int[] nums = {1,4,2,3};
        System.out.print(test.findKthLargest(nums, 2));
    }
}
