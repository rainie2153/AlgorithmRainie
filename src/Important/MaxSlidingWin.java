package Important;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 7/28/16.
 */
public class MaxSlidingWin {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int len = nums.length;
//        Queue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
//
//            public int compare(Integer e1, Integer e2) {
//                return Integer.compare(e2, e1);
//            }
//        });
//        int[] res = new int[len - k + 1];
//        for (int i = 0; i < k; i++) {
//            maxHeap.add(nums[i]);
//        }
//        res[0] = maxHeap.peek();
//        for (int i = k; i < len; i++) {
//            maxHeap.remove(nums[i - k]);
//            maxHeap.add(nums[i]);
//            res[i - k + 1] = maxHeap.peek();
//        }
//        return res;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return new int[0];

        Deque<Integer> deque = new LinkedList<Integer>();//deque里存的是index
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                res[j] = nums[deque.peekFirst()];
                j++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        MaxSlidingWin test = new MaxSlidingWin();
        int[] nums = new int[] {4,5,1,9,10};
        test.maxSlidingWindow(nums, 3);
    }
}
