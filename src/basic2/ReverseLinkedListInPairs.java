package basic2;

/**
 * Created by yuliu on 6/20/16.
 */
public class ReverseLinkedListInPairs {
    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = head.next;
        head.next = reverseInPairs(head.next.next);
        newhead.next = head;
        return newhead;
    }
}
