package mianjing;

/**
 * Created by yuliu on 9/24/16.
 */
public class BinaryTreeConvertToDDL {
    static class TreeNode{
        TreeNode left;//转换成DDL代表prev
        TreeNode right;//转换成DDL代表next
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] cur = new TreeNode[2];//0: Head 1: Tail [null] [null]
        helper(root, cur);
        //如果是要circle就在这里写下面两句
        //cur[1].right = cur[0];
        //cur[0].left = cur[1];
        return cur[0];
    }


    public void helper(TreeNode root, TreeNode[] cur) {
        if (root == null) {
            return;
        }
        helper(root.left, cur);
        if (cur[0] == null) {
            cur[0] = root;
            cur[1] = root;
        } else {
            cur[1].right = root;
            root.left = cur[1];
            cur[1] = cur[1].right;//cur[i] = root
        }
        helper(root.right, cur);
    }
}
