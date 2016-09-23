package basic2;

/**
 * Created by yuliu on 6/30/16.
 */
//Delete the target key K in the given Binary search tree if the binary search tree contains K.
    //Return the root of the binary search tree.
    //Find your own way to delete the node from the binary search tree, after deletion the binary search tree's
    //property should be maintained

public class BinarySearchTreeDelete {
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.key) {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;//意思在BST 里面右子节点要比root大,所以当you节点底下的左边没东西
                                            //这时候要把root删了,其实也可以root.left.right=root.right
                return root.right;//???
            } else {
                TreeNode newRoot = deleteSmallest(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }

        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        }
        return root;
    }

    private TreeNode deleteSmallest(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right;
        return smallest;
    }

    public static void main(String arg[]) {
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = eight;

        BinarySearchTreeDelete test = new BinarySearchTreeDelete();
        test.delete(seven, 7);
    }
}
