package basic1;

/**
 * Created by yuliu on 3/14/16.
 */
public class ReOrderLinkedList {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            //next = null;
        }
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode firsthalf = head;
        ListNode lasthalf = mid.next;

        mid.next = null;
        return merge(firsthalf, reverse(lasthalf));
    }

    private ListNode merge(ListNode First, ListNode Last) {
        if (First == null && Last == null) return null;
        ListNode dummyhead = new ListNode(0);
        ListNode curr = dummyhead;
        while (First != null && Last != null) {
            curr.next = First;
            First = First.next;
            curr.next.next = Last;
            Last = Last.next;
            curr = curr.next.next;
        }
        if (First != null) curr.next = First;
        else curr.next = Last;
        return dummyhead.next;
    }


    private ListNode reverse(ListNode head) {

        ListNode prev = null;//initalize

        while (head != null) {
            ListNode next = head.next;//store head pointer
            head.next = prev;//actual first time reverse
            prev = head;//prev point at head
            head = next;//head point at next
        }
        return prev;
    }

    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
