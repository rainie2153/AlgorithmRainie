package basic1;

/**
 * Created by yuliu on 3/14/16.
 */
public class MergeLinkedListUseDummy {
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
        while (one != null && two !=null) {
            if (one.value <= two.value) {
                curr.next = one;
                one = one.next;
            } else {curr.next =two;
                    two = two.next;}
            curr = curr.next;
        }//while循环走完后
        if (one != null) {
            curr.next = one;
        } else curr.next = two;//这三行是到后面不比较了,如果two里加好多数字进来,那么就要写这个来加remaining 的数

        return dummyhead.next;///////////特别注意是这个虚拟的头的下一个


    }

    public static void main(String[] args) {
        MergeLinkedListUseDummy rst = new MergeLinkedListUseDummy();
        ListNode one = new ListNode(0);
        one.next = new ListNode(3);
        one.next.next = new ListNode(6);
        one.next.next.next = new ListNode(8);
        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(7);
        two.next.next.next = new ListNode(9);
        two.next.next.next = new ListNode(10);




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
