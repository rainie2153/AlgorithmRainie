package LeetCode;

/**
 * Created by yuliu on 9/16/16.
 */
public class PalindromeLinkedList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode oneTail = findMid(head);
        ListNode twoHead = oneTail.next;
        oneTail.next = null;
        twoHead = reverse(twoHead);
        return compare(head, twoHead);
    }

    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private boolean compare(ListNode one, ListNode two){
        while(one != null && two != null) {
            if (one.val != two.val) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return true;
    }



    public static void main(String[] args) {
        PalindromeLinkedList rst = new PalindromeLinkedList();
        ListNode one = new ListNode(1);
        one.next = new ListNode(1);
        one.next.next = new ListNode(2);
        one.next.next.next = new ListNode(1);
//        one.next.next.next.next = new ListNode(2);
//        one.next.next.next.next.next= new ListNode(1);
        System.out.print(rst.isPalindrome(one));
    }

}
