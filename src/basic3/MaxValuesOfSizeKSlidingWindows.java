package basic3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuliu on 7/4/16.
 */
//Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from
    //left to right
    //The given array is not null and is not empty
    //K >= 1, K <= A.length
    //A = {1,2,3,2,4,2,1} K = 3, the windows are {{1,2,3},{2,3,2},{3,2,4},{2,4,2},{4,2,1}} and maximum values of
    //each K-sized sliding window are {3,3,4,4,4}
public class MaxValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while (!index.isEmpty() && array[index.peekFirst()] <= array[i]) {
                index.pollLast();
            }
            while (!index.isEmpty() && index.peekLast() >= i - k) {
                index.pollLast();
            }
            index.offerLast(i);
            if (i >= k - 1) {
                result.add(index.peekLast());
            }
        }
        return result;
    }
}
