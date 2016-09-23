package basic2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by yuliu on 3/16/16.
 */
public class KSmallestInUnsortedArray {
//    public int[] KSmallest (int[] array, int k) {
//        if (array.length == 0 || k == 0) return new int[0];
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                //== -> is a reference comparison, i.e. both objects point to the same memory location
//               // .equals() -> evaluates to the comparison of values in the objects
//                if(o1.equals(o2)) return 0;
//                return o1 > o2 ? -1: 1;
//            }
//        });
//        for (int i = 0; i < array.length; i++) {
//            if(i < k) {
//                maxHeap.offer(array[i]);//一个个存array进size为K的maxheap
//            } else if (array[i] < maxHeap.peek()) {
//                maxHeap.poll();
//                maxHeap.offer(array[i]);
//            }
//        }
//
//        int[] result = new int[k];
//        for (int i = k - 1; i >= 0; i --) {
//            result[i] = maxHeap.poll();
//        }
//        return result;
//    }
    //--------------------------------------------------------------override compare不懂

    public int[] KSmallest (int[] array, int k) {
        if (array.length == 0 || k == 0) return new int[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());//从大到小排列
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            }
            else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int [] result = new int[k];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result [i++] = maxHeap.poll();
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        KSmallestInUnsortedArray test = new KSmallestInUnsortedArray();
        int [] input = {3,4,1,2,5};
        int[] result = test.KSmallest(input, 3);
        System.out.print(Arrays.toString(result));
    }
}
