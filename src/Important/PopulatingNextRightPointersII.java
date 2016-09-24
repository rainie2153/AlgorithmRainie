package Important;

/**
 * Created by yuliu on 9/24/16.
 */
public class PopulatingNextRightPointersII {
    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        TreeLinkNode dummy = new TreeLinkNode(0);
        //loop the head in the level
        while (head != null) {
            //loop the cur in each level
            TreeLinkNode cur = head;
            TreeLinkNode child = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    child.next = cur.left;
                    child = cur.left;
                }
                if (cur.right != null) {
                    child.next = cur.right;
                    child = cur.right;
                }
                cur = cur.next;
            }
            head = dummy.next;
            dummy.next = null;
        }
    }

    public static void main(String args[]) {
        PopulatingNextRightPointersII test = new PopulatingNextRightPointersII();
        TreeLinkNode one = new TreeLinkNode(1);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode three = new TreeLinkNode(3);
        TreeLinkNode four = new TreeLinkNode(4);
        TreeLinkNode five = new TreeLinkNode(5);
        TreeLinkNode six = new TreeLinkNode(6);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;

        test.connect(one);
    }
}
