package Important;

/**
 * Created by yuliu on 8/30/16.
 *///Since n may be a large number compared to the length of list, so we need to know the length of linked list.
public class RotateList {
    public static class ListNode{
        ListNode next;
        int val;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int i;//i是有用的 记录下了整个linkedlist的长度
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

}
