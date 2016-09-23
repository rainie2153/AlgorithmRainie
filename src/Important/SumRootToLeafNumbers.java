package Important;

/**
 * Created by yuliu on 9/5/16.
 */
public class SumRootToLeafNumbers {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int currSum) {
        if (root.left == null && root.right == null) {
            currSum = currSum * 10 + root.val;
            return currSum;
        }
        currSum = currSum * 10 + root.val;
        int sum = 0;
        if (root.left != null) {
            sum += sumNumbers(root.left, currSum);
        }
        if (root.right != null) {
            sum += sumNumbers(root.right, currSum);
        }
        return sum;

    }
    public static void main(String args[]) {
        SumRootToLeafNumbers test = new SumRootToLeafNumbers();
        TreeNode ten = new TreeNode(1);
        TreeNode seven = new TreeNode(2);
        TreeNode twelve = new TreeNode(3);



        ten.left = seven;
        ten.right = twelve;



        System.out.print(test.sumNumbers(ten));
    }
}
