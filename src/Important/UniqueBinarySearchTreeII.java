package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 9/2/16.
 *///Given an integer n, generate all structurally unique BST's that stores values 1...n
    /*定义f(n)为Unique BST的数量, 以1为节点,left subtree只能有0个节点, right subtree有2,3个 一共f(0)*f(2)=2
    * 以2为节点,则left subtree只能为1, right subtree只能为2  f(1)* f(1) = 1
    * 以3为节点,则left subtree有1,2两个节点,right 有0个,f(2)*f(0) = 2
    * in conclusion, f(0) = 1
    * f(n) = f(0)*f(n-1) + f(1)*f(n-2)+...+f(n-2)*f(1)+f(n-1)*f(0)*/
public class UniqueBinarySearchTreeII {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            this.val = x;
        }
    }
    //第一种是yilun的方法
//    public List<Important.TreeNode> generateTrees(int n) {
//        if (n == 0) {
//            return new ArrayList<>();
//        }
//        Map<Integer, List<Important.TreeNode>> map = new Important.HashMap<>();
//        return generateTrees(1, n, n, map);
//    }
//
//    private List<Important.TreeNode>generateTrees(int left, int right, int n, Map<Integer, List<Important.TreeNode>> map) {
//        if (left > right) {
//            return Arrays.asList(new Important.TreeNode[]{null});
//        }
//        int key = n * left + right;
//        if (map.containsKey(key)) return map.get(key);
//
//        List<Important.TreeNode> res = new ArrayList<>();
//
//        for (int i = left; i <= right; i++) {
//            List<Important.TreeNode> leftNodes = generateTrees(left, i - 1, n, map);
//            List<Important.TreeNode> rightNodes = generateTrees(i + 1, right, n, map);
//            for (Important.TreeNode leftNode : leftNodes) {
//                for (Important.TreeNode rightNode : rightNodes) {
//                    Important.TreeNode root = new Important.TreeNode(i);
//                    root.left = leftNode;
//                    root.right = rightNode;
//                    res.add(root);
//                }
//            }
//        }
//
//        map.put(key, res);
//        return res;
//    }
    public List<TreeNode> generateTrees2(int n) {
        return helper(1, n);
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);//无解也算是一种解来对待
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);//end 选择的是左边构造的subtree
            List<TreeNode> right = helper(i + 1, end);//左边界设置的可以构造右边的subtree  i是root本身所以没有i

            //将左右子树的所有可能性都组装起来
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    //set root node
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;

                    //将组合出来的树加到结果集
                    res.add(root);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        UniqueBinarySearchTreeII test = new UniqueBinarySearchTreeII();
        System.out.print(test.generateTrees2(3));
    }

}
