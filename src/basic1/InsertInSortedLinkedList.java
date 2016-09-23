package basic1;

/**
 * Created by yuliu on 3/14/16.
 */
public class InsertInSortedLinkedList {
    static class ListNode {
        int value;
        ListNode next;
        ListNode (int value) {
            this.value = value;
        }
    }

    public ListNode insert(ListNode head, int value) {
        ListNode insertnode = new ListNode(value);

        if (head == null || head.value >= insertnode.value) {
            insertnode.next = head;
            return insertnode;
        }

        ListNode curr = head;
        //ListNode next = head.next;
//        while (curr != null) {
//            if(curr.next != null || insertnode.value < curr.next.value) {
//                curr.next = insertnode;
//                insertnode = head.next;
//                return head;
//            }
//            curr = curr.next;
//            head.next = head.next.next;
//
//        }
//    } .....?
        while (curr.next != null && curr.next.value < insertnode.value ) {
            curr = curr.next;
        }
        insertnode.next = curr.next;//不lost
        curr.next = insertnode;
        return head;
    }





    public static void main(String[] args) {
        InsertInSortedLinkedList rst = new InsertInSortedLinkedList();
        ListNode node = new ListNode(2);
        node.next = new ListNode(3);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(8);


        print(node);
        ListNode result = rst.insert(node, 4);
        print(result);
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.value);
            n = n.next;
        }
    }
}
