package LeetCode;

import java.util.PriorityQueue;

/**
 * Created by yuliu on 8/6/16.
 */
public class KthSmallestNumberInSortedMatrix {
    static  class Triplet implements Comparable<Triplet> {
        int x, y, val;
        public Triplet (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo (Triplet another) {
            return this.val - another.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Triplet> minHeap = new PriorityQueue<Triplet>();
        for (int j = 0; j < n; j++) {
            minHeap.offer(new Triplet(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Triplet t = minHeap.poll();
            if(t.x == n - 1) continue;
            minHeap.offer(new Triplet(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return minHeap.poll().val;
    }
    public static void main(String args[]) {
        KthSmallestNumberInSortedMatrix test = new KthSmallestNumberInSortedMatrix();
        int[][] matrix = {  {1, 5, 9},
                            {10, 11, 13},
                            {12, 13, 15}};
        System.out.print(test.kthSmallest(matrix, 6));
    }
}


