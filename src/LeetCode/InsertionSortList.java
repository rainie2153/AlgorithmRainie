package LeetCode;

/**
 * Created by yuliu on 8/9/16.
 */
public class InsertionSortList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);//9->3->6->4

        while (head != null) {
            ListNode cur = dummy;//cur = 0
            while (cur.next != null && cur.next.val < head.val) {//9>3
                cur = cur.next;
            }
            ListNode next = head.next;//temp = null
            head.next = cur.next;//3->9
            cur.next = head;//dummy-3-9-null
            head = next;//head = 6
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        InsertionSortList rst = new InsertionSortList();
        ListNode node = new ListNode(9);
        node.next = new ListNode(3);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(4);


        print(node);
        ListNode result = rst.insertionSortList(node);
        print(result);
    }

    static void print(ListNode n) {
        while (n!=null) {
            System.out.print(n.val);
            n = n.next;
        }
    }
}

