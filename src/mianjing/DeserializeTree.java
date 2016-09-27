package mianjing;


import java.util.*;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuliu on 9/6/16.
 */

public class DeserializeTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(","));
        Deque<String> datas = new LinkedList<>();
        datas.addAll(list);
        return reconstruct(datas);
    }

    public TreeNode reconstruct(Queue<String> datas) {
        if (datas.isEmpty()) {
            return null;
        }
        String curr = datas.poll();
        if (curr.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer. parseInt(curr));
        root.left = reconstruct(datas);
        root.right = reconstruct(datas);
        return root;
    }
    public static void main(String[] args) {
        DeserializeTree test = new DeserializeTree();
        TreeNode one = new TreeNode(10);
        TreeNode two = new TreeNode(5);
        TreeNode three = new TreeNode(6);
        one.left = two;
        two.right = three;
        test.deserialize("1,2,#,#,3,#,#");
        System.out.println(test.serialize(one));
        System.out.println(test.inorderSuccessor(one,three).val);

    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        treeToString(root, sb);
        return sb.toString();
    }

    public void treeToString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        treeToString(root.left, sb);
        treeToString(root.right, sb);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
    /*   加入变种不问sucessor问比目标的上一个parent就是最小的比target大的node
         while (root != null) {
            if (root.val >= p.val) {
                root = root.left;
            } else {
                successor = root;
                root = root.right;
            }
        }*/
}
