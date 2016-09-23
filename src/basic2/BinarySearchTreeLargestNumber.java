package basic2;

/**
 * Created by yuliu on 6/30/16.
 */
public class BinarySearchTreeLargestNumber {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    public int largestSmallest(TreeNode root, int target) {
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;
            } else {//The candidates are all nodes that on the path of searching for target which is smaller than the
                //target but it is the largest one. The later searched node has larger value than earlier searched ones
                result = root.key;
                root = root.right;
            }
        }
        return result;
    }
}
