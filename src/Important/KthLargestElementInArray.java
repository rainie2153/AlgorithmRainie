package Important;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yuliu on 9/16/16.
 */

//method 1 minHeap time : O(nlogk)  space : O(k)
    /*maintain a k size minHeao, compare each element from the array with the top of minHeap, if it is larger
    * than root, then we delete the root and add the larger element to the minHeap, if smaller than root, we do
    * nothing and traverse the next element*/
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int x : nums) {
            if (q.size() < k) {
                q.offer(x);
            } else {
                int top = q.peek();
                if (x > top) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        return q.peek();
    }

//method 2 . partition  time O(n)  space O(1)
    public int findKthLargest2(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private int findKthLargest2(int[] nums, int left, int right, int k) {
        if(left == right - 1 && k == 1) {
            return nums[0];
        }

        int pos = partition(nums, left, right - 1);
        int len = pos - left;

        if(len == k) {
            return nums[pos - 1];
        } else if (len < k) {
            return findKthLargest2(nums, pos, right, k - len);
        } else {
            return findKthLargest2(nums, left, pos, k);
        }

    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while(left < right) {
            while(left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;

    }


    public static void main(String args[]) {
        KthLargestElementInArray test = new KthLargestElementInArray();
        int[] nums = {10,6,5,7};
        System.out.print(test.findKthLargest2(nums, 3));
    }
}
