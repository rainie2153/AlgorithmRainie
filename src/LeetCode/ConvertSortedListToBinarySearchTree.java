package LeetCode;

/**
 * Created by yuliu on 9/3/16.
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x) {
            this.val = x;
        }
    }
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = getLinkedListSize(head);
        return sortedListToBST(head, size);
    }

    private int getLinkedListSize(ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
    private TreeNode sortedListToBST(ListNode head, int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = sortedListToBST(head, size / 2);

        int i = 0;
        ListNode pointer = head;

        while (i < size / 2) {
            pointer = pointer.next;
            i++;
        }
        TreeNode root = new TreeNode(pointer.val);

        TreeNode right = sortedListToBST(pointer.next, size - size / 2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }
    public static void main(String args[]) {
        ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        //node.next.next.next.next.next.next.next.next = new ListNode(9);

        int val = test.sortedListToBST(node).val;
        System.out.print(val);
    }
}
