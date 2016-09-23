package Important;

/**
 * Created by yuliu on 6/20/16.
 */
//Given two nodes in a binary tree find their lowest common ancestor.
//Assumptions: There is no parent pointer for the nodes in the binary tree
//The given two nodes are guaranteed to be in the binary tree
class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode( int key) {
        this.left = null;
        this.right = null;
        this.key = key;
    }
}

public class LCAwithParent {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {//one is 2,two is 12
        if (root == null) {
            return null;//base case
        }
        if (root == one || root == two) {
            return root;
        }
        int h1 = getHeight(one);
        int h2 = getHeight(two);
        while(h1 > h2) {
            if(one == null) {
                return null;
            }
            one = one.parent;
            h1--;
        }

        while(h1 < h2) {
            if(two == null) {
                return null;
            }
            two = two.parent;
            h2--;
        }

        while(one != null && two != null) {
            if (one == two) {
                return one;
            }
            one = one.parent;
            two = two.parent;
        }
        return null;
    }

    private int getHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.parent;
        }
        return height;
    }

    public static void main(String arg[]) {
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);

        ten.left = seven;
        seven.parent = ten;
        ten.right = twelve;
        twelve.parent = ten;
        seven.left = two;
        two.parent = seven;
        seven.right = five;
        five.parent = seven;

        LCAwithParent test = new LCAwithParent();

        System.out.print(test.lowestCommonAncestor(ten, five, twelve).key);

    }
}
