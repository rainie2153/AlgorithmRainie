package Important;

/**
 * Created by yuliu on 9/7/16.
 */
public class InorderSuccessorBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {//p就相当于二分查找的target
        if (root == null) {
            return null;
        }
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return successor;
    }
    public static void main(String[] args) {
        InorderSuccessorBST test = new InorderSuccessorBST();
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode fourteen = new TreeNode(14);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = eight;
        twelve.left = eleven;
        twelve.right = fourteen;
        int a = test.inorderSuccessor(ten, twelve).val;
        System.out.print(a);
    }
}
