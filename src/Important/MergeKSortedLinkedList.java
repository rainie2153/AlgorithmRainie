package Important;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuliu on 7/15/16.
 */
public class MergeKSortedLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            this.val = x;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new MyComparator());
        ListNode beforeHead = new ListNode(555);
        ListNode cur = beforeHead;
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);//先把list中的每个Linklist的头全加到minheap 中排序
            }
        }
        while(!minHeap.isEmpty()) {//Linklist 1-2-3-------2 31-1 O(n)  nodes X=3   x*Nlog(x)    x*N
            cur.next = minHeap.poll();//minHeap ListNode whole Linkedlist
            if (cur.next.next != null) {
                minHeap.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return beforeHead.next;
    }
    static class MyComparator implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2) {
            if (l1.val == l2.val) return 0;
            return l1.val < l2.val ? -1 : 1;
        }
    }
    public static void main(String[] args) {


        ListNode[] node = new ListNode[3];
        node[0] = new ListNode(0);
        node[0].next = new ListNode(2);
        node[0].next.next = new ListNode(7);
        node[1] = new ListNode(1);
        node[1].next = new ListNode(9);
        node[2] = new ListNode(3);
        node[2].next = new ListNode(8);
        print(node[0]);
        print(node[1]);
        print(node[2]);
        MergeKSortedLinkedList test = new MergeKSortedLinkedList();
        System.out.println();
        print(test.mergeKLists(node));



    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }

}
