package basic2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuliu on 3/17/16.
 */
public class GetKeysInBinaryTreeLayerByLayer {

    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode (int key) {
            this.key = key;
        }
    }

    public List<List<Integer>> layerByLayer (TreeNode root) {
        List<List<Integer>> list =  new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                layer.add(cur.key);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }list.add(layer);
        }
    return list;
    }

    public static TreeNode root;
    public static void main(String[] args) {
        GetKeysInBinaryTreeLayerByLayer test = new GetKeysInBinaryTreeLayerByLayer();


        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;


        test.display(test.root);
    }

    public void display(TreeNode root) {
        List<List<Integer>> rst = layerByLayer(root);

        for (List<Integer> node : rst)
            System.out.print(node + " ");
    }


}
