package Important;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 7/29/16.
 */
public class VerifyPreorder {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        int low = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < low) return false;
            while (!stack.isEmpty() && stack.peek() < preorder[i]) {
                low = stack.pop();//2//5//8
            }
            stack.push(preorder[i]);//7,4,,,9,,10
        }

        return true;
    }
    public static void main(String args[]) {
        VerifyPreorder test = new VerifyPreorder();
        int[] input = {7,4,2,5,9,8,10};
        System.out.print(test.verifyPreorder(input));
    }
}
