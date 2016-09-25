package LeetCode;

/**
 * Created by yuliu on 8/26/16.
 */
public class ReverseNodesInKGroup {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int counter = 0;
        ListNode cur = head;
        while (cur != null && counter != k) {
            cur = cur.next;
            counter++;
        }

        //思想 reverse linkedlist
        if (counter == k) {
            cur = reverseKGroup(cur, k);
            while (counter > 0) {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
                counter--;
            }
            head = cur;
        }
        return head;
    }
    public static void main(String args[]) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        ReverseNodesInKGroup test = new ReverseNodesInKGroup();
        test.reverseKGroup(node, 3);
    }
}
