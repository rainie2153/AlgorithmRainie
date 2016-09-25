package LeetCode;

/**
 * Created by yuliu on 7/19/16.
 */
public class DeleteDuplicateLinkedList {

    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode slow = head;
//        for (ListNode fast = head.next; fast != null; fast = fast.next) {
//            if (fast.val != slow.val) {
//                slow.next = fast;
//                slow = slow.next;
//            }
//        }
//        slow.next = null;
//        return head;
//    }
//------------------------Wrong ans--------------------------

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;

        for (;fast != null;fast = fast.next) {
            if (slow.val == fast.val) {
                continue;
            } else {

                slow.next = fast;
                slow = slow.next;

            }
        }
        if (fast == null) slow.next = null;
        return head;
    }
    //------------------------Wrong ans--------------------------

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);

        DeleteDuplicateLinkedList test = new DeleteDuplicateLinkedList();
        print(test.deleteDuplicates(node));
    }

    static void print(ListNode n) {
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
