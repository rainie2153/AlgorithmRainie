package basic1;

import java.util.ArrayList;

/**
 * Created by yuliu on 3/15/16.
 */
public class Pre_In_Post_Traversal {
    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }
//-----------------------------------stackoverflow er///////
//    public ArrayList<Integer> inOrder(TreeNode root) {
//        if (root == null) return null;
//        TreeNode cur = root;
//
//        while (cur != null) {
//            inOrder(root.left);
//            //System.out.print(Arrays.toString(cur.key));
//            inOrder(root).add(cur.key);
//            inOrder(root.right);
//        }
//        return inOrder(root);
//    }

    public ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        //while (root != null) {
        helper(root.left, result);

        helper(root.right, result);
        result.add(root.key);

        //}
    }


    public static TreeNode root;


    //    public void insert(int id){
//        TreeNode newNode = new TreeNode(id);
//        if(root==null){
//            root = newNode;
//            return;
//        }
//        TreeNode current = root;
//        TreeNode parent = null;
//        while(true){
//            parent = current;
//            if(id<current.key){
//                current = current.left;
//                if(current==null){
//                    parent.left = newNode;
//                    return;
//                }
//            }else{
//                current = current.right;
//                if(current==null){
//                    parent.right = newNode;
//                    return;
//                }
//            }
//        }
//    }
    public void display(TreeNode root) {
        ArrayList<Integer> rst = inOrder(root);

        for (int i : rst)
            System.out.print(i + " ");
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
        Pre_In_Post_Traversal b = new Pre_In_Post_Traversal();
        b.root = ten;


//        System.out.println("Original Tree : ");
//        b.display(b.root);

        System.out.println("ordered Tree : ");
//        b.inOrder(b.root);
        b.display(b.root);

    }


}
