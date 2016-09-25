package LeetCode;

/**
 * Created by yuliu on 8/24/16.
 */
public class AddTwoNumbers {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int result = carry;
            if (l1 != null) {
                result += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result += l2.val;
                l2 = l2.next;
            }
            carry = result / 10;
            result %= 10;
            cur.next = new ListNode(result);
            cur = cur.next;
            if (carry == 1) {
                ListNode car = new ListNode(carry);
                cur.next = car;
            }
        }
        return dummy.next;
    }
}

