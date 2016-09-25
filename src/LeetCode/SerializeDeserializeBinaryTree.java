package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuliu on 9/7/16.
 */
public class SerializeDeserializeBinaryTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }
    //Encode a tree to a single string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return  sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(","));//先把string1,#,2,3搞成list
        Queue<String> datas = new LinkedList<>();
        datas.addAll(list);//把list"1","#","2","3"放queue
        return buildTree(datas);
    }

    private TreeNode buildTree(Queue<String> datas) {
        if (datas.isEmpty()) {
            return null;
        }
        String cur = datas.poll();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = buildTree(datas);
        root.right = buildTree(datas);
        return root;
    }
}
