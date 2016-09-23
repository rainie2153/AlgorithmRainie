package basic2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 7/1/16.
 */
//Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree
    //The given sequences are not null and have the same length
    //no duplicate keys in the binary tree
    //levelorder traversal = {5,3,8,1,4,11}用ArrayList存一维的数组
    //inorder traversal = {1,3,4,5,8,11}用Map存每个元素对应的值,以及index
public class ReconstructLevelorderAndInorder {
    public TreeNode reconstruct(int[] level, int[] in) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        List<Integer> levelList = new ArrayList<Integer>();
        for (int num : level) {
            levelList.add(num);
        }
        return helper(levelList, inMap);
    }

        private TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap) {
            if (level.isEmpty()) {
                return null;
            }
            TreeNode root = new TreeNode(level.remove(0));
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for (int num : level) {
                if (true) {

                }
            }
            return root;
        }
}


