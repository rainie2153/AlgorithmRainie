package basic2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuliu on 6/29/16.
 */
public class ZigZag {
    public List<Integer> zigZig(TreeNode root) {//输入是treenode然后结果返回的是个linkedlist
        if (root == null) {
            return new LinkedList<>();
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        deque.offerFirst(root);
        int layer = 0;
        while(!deque.isEmpty()) {
            int size = deque.size();//the deque's size is changeing so that we have to store size beforehead
            for (int i = 0; i < size; i++) {
                if (layer == 0) {//实际的奇数层(layer是代表的layer的index)
                    TreeNode tmp = deque.pollLast();
                    list.add(tmp.key);
                    if (tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }
                } else {//实际的偶数层
                    TreeNode tmp = deque.pollFirst();
                    list.add(tmp.key);
                    if(tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if(tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        System.out.print(list);
        return list;
    }
    public static void main(String[] args) {
        ZigZag test = new ZigZag();


        TreeNode ten = new TreeNode(10);
        TreeNode seven = new TreeNode(7);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);


        ten.left = seven;
        ten.right = twelve;
        seven.left = two;
        seven.right = five;


        test.zigZig(ten);
    }




}
