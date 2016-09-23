package basic2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuliu on 6/30/16.
 */
//Merge K sorted lists into one big sorted list in ascending order(it is already sorted list)
    //List of lists is not null and none of the lists is null
public class MergeKSortedList {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }

    }
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            length += array.length;
            if (array.length != 0) {
                minHeap.offer(new Entry(i, 0, array[0]));
            }
        }
        int[] result = new int[length];
        int cur = 0;
        while(!minHeap.isEmpty()) {
            Entry tmp = minHeap.poll();
            result[cur++] = tmp.value;
            if (tmp.y + 1 < arrayOfArrays[tmp.x].length) {
                tmp.y++;
                tmp.value = arrayOfArrays[tmp.x][tmp.y];
                minHeap.offer(tmp);
            }
        }
        return result;
    }

    class Entry {
        int x;
        int y;
        int value;
        Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    class MyComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1, Entry e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }

    }
}
