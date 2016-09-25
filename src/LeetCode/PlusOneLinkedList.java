package LeetCode;

/**
 * Created by yuliu on 7/31/16.
 */
public class PlusOneLinkedList {
    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
    }
    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        int res = helper(head);
        if(res == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    private int helper(ListNode node){
        if(node == null) return 1;
        int next = helper(node.next);
        int sum = node.val + next;
        node.val = sum % 10;
        return sum / 10;
    }
    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(9);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
//        node.next.next.next.next.next.next = new ListNode(7);
//        node.next.next.next.next.next.next.next = new ListNode(8);
//        node.next.next.next.next.next.next.next.next = new ListNode(9);


        PlusOneLinkedList test = new PlusOneLinkedList();
        print(test.plusOne(node));
    }
    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }

}
