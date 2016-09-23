package basic1;

/**
 * Created by yuliu on 3/14/16.
 */
public class CheckIfLinkedListHasACircle {
    static class ListNode {
        int value;
        ListNode next;
        ListNode (int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast =head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            } //else return false;这块被我注释掉的是错的 容易犯错
        } return false;
    }
}
