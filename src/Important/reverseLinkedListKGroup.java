package Important;

/**
 * Created by yuliu on 7/16/16.
 */
public class reverseLinkedListKGroup {

    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            this.val = x;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int counter = 0;
        ListNode curr = head;
        while (curr != null && counter != k ) {
            curr = curr.next;//789
            counter++;//走到position k+1
        }

        if (counter == k) {//到了后反转
            curr = reverseKGroup(curr, k);

            while(counter > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
                counter--;

            }
            head = curr;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
//        node.next.next.next.next.next.next = new ListNode(7);
//        node.next.next.next.next.next.next.next = new ListNode(8);
//        node.next.next.next.next.next.next.next.next = new ListNode(9);


        reverseLinkedListKGroup test = new reverseLinkedListKGroup();
        print(test.reverseKGroup(node, 3));
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}

