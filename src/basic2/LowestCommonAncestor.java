package basic2;

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
    public TreeNode( int key) {
        this.left = null;
        this.right = null;
        this.key = key;
    }
}

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {//one is 2,two is 12
        if (root == null) {
            return null;//base case
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode l1 = lowestCommonAncestor(root.left, one, two);//走到2,BP,stack frame
        TreeNode lr = lowestCommonAncestor(root.right, one, two);//find node one and node two
        if (l1 != null && lr != null) {//means I have found node one and two

            System.out.print(root.key);
            return root;
        }
        return l1 == null ? lr : l1;
    }

    public static void main(String arg[]) {
        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;

        //BinarySearchTree b = new BinarySearchTree();
        LowestCommonAncestor test = new LowestCommonAncestor();


//        System.out.println("Original Tree : ");
//        b.display(b.root);
        test.lowestCommonAncestor(ten, two, twelve);
        //System.out.println("ordered Tree : ");

//        b.inOrder(b.root);

    }
}
