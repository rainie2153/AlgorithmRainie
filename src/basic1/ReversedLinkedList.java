package basic1;

/**
 * Created by yuliu on 3/14/16.
 */
public class ReversedLinkedList {


    public ListNode reverse(ListNode head) {
        //---------------------------------iterative
//        ListNode prev = null;//initalize
//
//        while (head!=null) {
//            ListNode next = head.next;//store head pointer
//            head.next = prev;//actual first time reverse
//            prev = head;//prev point at head
//            head = next;//head point at next
//        }
//        return prev;
        //---------------------------------recursive
        if (head == null || head.next == null) return head;
        ListNode next = head.next;//store head pointer
        ListNode newhead = reverse(next);//subproblem
        next.next = head;
        head.next = null;
        return newhead;
    }

//     static class ListNode {
//        public int value;
//        public ListNode next;
//        public ListNode(int value) {
//            this.value = value;
//            next = null;
//            }
//    }
    static class ListNode {
        int value;
        ListNode next;
        ListNode (int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ReversedLinkedList rst = new ReversedLinkedList();
        ListNode node = new ListNode(2,new ListNode(3, new ListNode(4, null)));
//        node.next = new ListNode(3);
//        node.next.next = new ListNode(4);
//        node.next.next.next = new ListNode(5);


        print(node);
        ListNode result = rst.reverse(node);
        print(result);
    }

     static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.value);
            n = n.next;
        }
     }
}
