package Important;

/**
 * Created by yuliu on 9/4/16.
 */
public class ConectNextPointer {
    static class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;

        TreeLinkNode(int x) {
            this.val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root, tmpNode = new TreeLinkNode(0);
        //loop the head in the level
        while (head != null) {
            //loop the node in each level
            TreeLinkNode node = head, child = tmpNode;
            while (node != null) {
                if (node.left != null) {
                    child.next = node.left;
                    child = node.left;
                }
                if (node.right != null) {
                    child.next = node.right;
                    child = node.right;
                }
                node = node.next;
            }
            head = tmpNode.next;
            tmpNode.next = null;
        }
    }

    public static void main(String[] args) {
        ConectNextPointer test = new ConectNextPointer();
        TreeLinkNode ten = new TreeLinkNode(10);
        TreeLinkNode seven = new TreeLinkNode(7);
        TreeLinkNode twelve = new TreeLinkNode(12);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode five = new TreeLinkNode(5);
        TreeLinkNode eleven = new TreeLinkNode(11);
        TreeLinkNode fourteen = new TreeLinkNode(14);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;
        twelve.left = eleven;
        twelve.right = fourteen;
        test.connect(ten);
    }
}
