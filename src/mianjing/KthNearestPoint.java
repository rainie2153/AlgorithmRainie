package mianjing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuliu on 9/24/16.
 * kth closest points to the origin in 2D plane, given an array containing N points
 * 找离原点最近的点，可多解
 */
public class KthNearestPoint {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public List<Point> findKthNearest(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(11, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (o2.x * o2.x + o2.y * o2.y) - (o1.x * o1.x + o2.y + o2.y);
            }
        });

        for(int i = 0; i < points.length; i++) {
            if (i < k) {
                maxHeap.offer(points[i]);
            } else {
                Point top = maxHeap.peek();
                int curPVal = points[i].x * points[i].x + points[i].y * points[i].y;
                if (curPVal < top.x * top.x + top.y * top.y) {
                    maxHeap.poll();
                    maxHeap.offer(points[i]);
                }
            }
        }
        List<Point> res = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            System.out.print(maxHeap.peek().x);
            res.add(maxHeap.poll());//第一个顶端的是第K小的，这个循环打印出前面K个小的数字全部
        }
        return res;
    }

    public static void main(String args[]) {
        KthNearestPoint test = new KthNearestPoint();
        Point one = new Point(100,2);
        Point two = new Point(2,3);
        Point three = new Point(3,6);
        Point four = new Point(1,2);
        Point[] points = {one, two, three, four};
        test.findKthNearest(points, 3);
    }

}
