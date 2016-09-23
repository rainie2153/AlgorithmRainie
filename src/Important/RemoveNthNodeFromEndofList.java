package Important;

/**
 * Created by yuliu on 8/26/16.
 */
public class RemoveNthNodeFromEndofList {
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null || head.next == null) {
//            return null;
//        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public static void main(String args[]) {
        RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        test.removeNthFromEnd(head, 2);
        test.print(head);
    }
    private void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

}
