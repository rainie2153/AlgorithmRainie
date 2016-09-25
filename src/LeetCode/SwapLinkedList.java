package LeetCode;

/**
 * Created by yuliu on 7/15/16.
 */
public class SwapLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            this.val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode beforeHead = new ListNode(555);
        ListNode prev = beforeHead;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode nextnext = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            prev = curr;
            curr = nextnext;
        }
        prev.next = null;
        return beforeHead.next;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        SwapLinkedList test = new SwapLinkedList();
        print(test.swapPairs(node));
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
