package Important;

/**
 * Created by yuliu on 9/2/16.
 */
public class ReverseLinkedListII {
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        ListNode newReverseHead = prev.next;
        prev.next = reverse(prev.next, cur);//reverse这个返回的是个头
        newReverseHead.next = cur;
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        while(head != tail) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);


        ReverseLinkedListII test = new ReverseLinkedListII();
        print(test.reverseBetween(node, 2, 4));
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
