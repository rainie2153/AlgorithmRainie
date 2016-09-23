package basic1;

/**
 * Created by yuliu on 3/15/16.
 */
public class PartitionLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            this.val = x;
        }
    }
//
//    public ListNode partition(ListNode head, int target) {// one理解为one这个node开头的一个链表就是链表1的头
//        if (head == null) {
//            return null;
//        }
//        ListNode dummyhead1 = new ListNode(0);//比target小的放左边
//        ListNode dummyhead2 = new ListNode(0);//比target大的放右边
//        ListNode tail1 = dummyhead1;
//        ListNode tail2 = dummyhead2;
//        ListNode curr = head;
//
//        while (curr != null) {
//            if (curr.value < target) {
//                tail1.next = curr;
//                tail1 = curr;
//            } else {
//                tail2.next = curr;
//                tail2 = curr;
//            }
//            curr = curr.next;
//        }
//        tail2.next =null;
//        tail1.next = dummyhead2.next;
//        return dummyhead1.next;
//    }
////--------------上面是正确答案 我下面自己再重新写下
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode cur = head;
        ListNode head1 = smallDummy;
        ListNode head2 = largeDummy;//保留对头的所有权 否则没办法返回也没办法把small part跟large part链接起来
        while(cur != null) {
            if (cur.val < x) {
                smallDummy.next = cur;
                smallDummy = smallDummy.next;
            } else {
                largeDummy.next = cur;
                largeDummy = largeDummy.next;
            }
            cur = cur.next;
        }
        smallDummy.next = head2.next;
        largeDummy.next = null;
        return head1.next;
    }




    public static void main(String[] args) {
        PartitionLinkedList rst = new PartitionLinkedList();
        ListNode one = new ListNode(1);
        one.next = new ListNode(4);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(2);
        one.next.next.next.next = new ListNode(5);
        one.next.next.next.next.next= new ListNode(2);
        String s = "%%%";
        System.out.print(s);


        ListNode result = rst.partition(one, 3);
        print(result);
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}
