package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuliu on 8/26/16.
 */
public class MergeKSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode mergeKList(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new MyComparator());
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        while(!minHeap.isEmpty()) {
            cur.next = minHeap.poll();//顶上都是最小的元素,这个算法的核心就是谁小移谁
            if (cur.next.next != null) {
                minHeap.offer(cur.next.next);
            }
            cur = cur.next;
        }

        return dummy.next;
    }
    static class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
//            if (o1.val == o2.val) {
//                return 0;
//            }
//            if (o1.val < o2.val) {
//                return -1;
//            } else return 1;
            return o1.val - o2.val;
        }
    }
    public static void main(String args[]) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(5);
        a.next.next = new ListNode(6);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        ListNode[] nodes = {a, b, c ,d};
        MergeKSortedList test = new MergeKSortedList();
        test.mergeKList(nodes);
    }
}
