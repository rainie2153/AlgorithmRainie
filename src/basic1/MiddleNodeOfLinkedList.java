package basic1;

/**
 * Created by yuliu on 3/14/16.
 */
public class MiddleNodeOfLinkedList {

    static class ListNode {
        int value;
        ListNode next;
        ListNode (int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
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

    public static void main(String[] args) {
        MiddleNodeOfLinkedList rst = new MiddleNodeOfLinkedList();
        ListNode node = new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(4, null))));
//        node.next = new ListNode(3);
//        node.next.next = new ListNode(4);
//        node.next.next.next = new ListNode(5);


        print(node);
        ListNode result = rst.middleNode(node);
        print(result);
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.value);
            n = n.next;
        }
    }

}
