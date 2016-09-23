package basic2;

/**
 * Created by yuliu on 7/1/16.
 */
public class ReconstructPostorder {
    public TreeNode reconstruct(int[] post) {
        //travese and construct the binary search tree from right to left
        int[] index = new int[] {post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] postorder, int[] index, int min) {
        if (index[0] < 0 || postorder[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index[0]--]);
        root.right = helper(postorder, index, root.key);
        root.left = helper(postorder, index, min);
        return root;
    }
    public static void main(String[] args) {
        ReconstructPostorder test = new ReconstructPostorder();
        int[] post = {1,4,3,11,8,5};
        test.reconstruct(post);
    }
}
