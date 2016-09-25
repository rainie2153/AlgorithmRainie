package LeetCode;

/**
 * Created by yuliu on 8/26/16.
 */
public class SwapNodesInPairs {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    //Method1: recursion
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;//这是先找到头
        head.next = swapPairs(head.next.next);
        newHead.next = head;

        return newHead;
    }
}
