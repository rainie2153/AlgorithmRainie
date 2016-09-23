package basic3;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by yuliu on 7/3/16.
 */
//Find kth smallest number s such that s = 3^x*5^y*7^z
    //the smallest is 3*5*7=105
    //the 2nd smallest is 3^2*5*7
public class KthSmallestWithOnly357AsFactors {
    public long kth(int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        Set<Long> visited = new HashSet<>();
        minHeap.offer(3*5*7L);
        visited.add(3*5*7L);
        while(k > 1) {
            long current = minHeap.poll();
            if (visited.add(3 * current)) {
                minHeap.offer(3 * current);
            }
            if (visited.add(5 * current)) {
                minHeap.offer(5 * current);
            }
            if (visited.add(7 * current)) {
                minHeap.offer(7 * current);
            }
           k--;
        }
        return minHeap.peek();
    }
}
