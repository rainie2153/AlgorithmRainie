package basic1;

/**
 * Created by yuliu on 3/14/16.
 */
public class MergeTwoSortedLinkedLists {
    static class ListNode {
        int value;
        ListNode next;
        ListNode (int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode merge(ListNode one, ListNode two) {// one理解为one这个node开头的一个链表就是链表1的头
        if (one == null && two == null) return null;


        ListNode dummyhead = new ListNode(0);
        ListNode curr = dummyhead;


        while (one != null && two != null) {
            if (one.value <= two.value) {
                curr.next = merge(one.next,two);

            } else if (one.value > two.value) {
                curr.next = merge(two.next, one);

            }
            curr = curr.next;
        }

        return dummyhead.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedLists rst = new MergeTwoSortedLinkedLists();
        ListNode one = new ListNode(0);
        one.next = new ListNode(3);
        one.next.next = new ListNode(6);
        one.next.next.next = new ListNode(8);
        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(7);
        two.next.next.next = new ListNode(9);



        ListNode result = rst.merge(one, two);
        print(result);
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.value);
            n = n.next;
        }
    }


}
