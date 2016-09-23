package basic3;

import java.util.*;

/**
 * Created by yuliu on 7/3/16.
 */
//Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate<x,y,z> in a 3D space
    //Find the coordinates of the points that is Kth closest to <0,0,0>
    //We are using euclidean distance here
    //Assumptions: the three given arrays are not null or empty
    //K>=1 and k<=a.length*b.length*c.length
    //A = {1,3,5} B={2,4} C={3,6}
    //The closest is <1,2,3> distance is sqrt(1+4+9)//The second closest <3,2,3> distance is sqrt(9+4+9)
public class KthClosestPointTo {
    public List<Integer> closest(final int[] a, final int[] b,final int[] c, int k) {
        //use minheap with comparator to compare the distance
        //Note that we are using the index in a,b,c as values in the List<Integer>
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long d1 = distance(o1, a, b, c);
                long d2 = distance(o1, a, b, c);
                if (d1 == d2) {
                    return 0;
                }
                return d1 < d2 ? -1 : 1;
            }
        });

        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> cur = Arrays.asList(0, 0, 0);//pick smallest number from three arrays
        visited.add(cur);
        minHeap.offer(cur);
        while (k > 0) {
            cur = minHeap.poll();
            //---------------
            List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (n.get(0) < a.length && visited.add(n)) {
                minHeap.offer(n);
            }

            //----------------
            n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (n.get(1) < b.length && visited.add(n)) {
                minHeap.offer(n);
            }

            //----------------
            n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (n.get(2) < c.length && visited.add(n)) {
                minHeap.offer(n);
            }
            k--;
        }
        // at last we replace the index with actual values in a, b, c
        cur.set(0, a[cur.get(0)]);
        cur.set(1, b[cur.get(1)]);
        cur.set(2, c[cur.get(2)]);
        return cur;
        }

    private long distance(List<Integer> point, int[] a, int[] b, int[] c) {
        long dis = 0;
        dis += a[point.get(0)] * a[point.get(0)];
        dis += b[point.get(1)] * b[point.get(1)];
        dis += c[point.get(2)] * c[point.get(2)];
        return dis;
    }

    public static void main (String[] args) {
        KthClosestPointTo test = new KthClosestPointTo();
        int[] a = {1, 3, 5};
        int[] b = {2, 4};
        int[] c = {3, 6};
        test.closest(a, b, c, 3);
        HashSet hs = new HashSet();
        hs.add("R");
        hs.add("B");
        hs.add("A");
        hs.add("F");
        hs.add("E");
        System.out.print(hs);
    }
}
