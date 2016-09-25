package LeetCode;

/**
 * Created by yuliu on 8/26/16.
 */
public class MergeTwoSortedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null || l2 != null) {//意思是有一个为null可以  但是如果两个都为null了就不能进入这个while循环了
            if (l1 == null) {
                cur.next = l2;
                l2 = l2.next;
            } else
            if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
            } else
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    public static void main(String args[]) {
        MergeTwoSortedList test = new MergeTwoSortedList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        test.mergeTwoLists(l1, l2);

    }
    private void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
