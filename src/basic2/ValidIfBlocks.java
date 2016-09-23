package basic2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 6/29/16.
 */
public class ValidIfBlocks {
    public void validIfBlocks(int n) {
        if(n <= 0) {
            return;
        }
        List<String> blocks = new ArrayList<String>();
        helper(blocks, n, n);
    }
    private void helper(List<String> blocks, int left, int right) {
        if (left == 0 && right == 0) {
            print(blocks);
            return;
        }
        StringBuffer builder = new StringBuffer();
        if (left > 0) {
            for (int i = 0; i < right - left; i++) {
                builder.append(" ");
            }
            blocks.add(builder.append("if {").toString());
            helper(blocks, left - 1, right);
            blocks.remove(blocks.size() - 1);
        }
        builder.setLength(0);//use setLength(0) to reset StringBuilder or creating a new in each iteration.
        if (right > left) {
            for (int i = 0; i < right - left - 1; i++) {
                builder.append("  ");
            }
            blocks.add(builder.append("}").toString());
            helper(blocks, left, right - 1);
            blocks.remove(blocks.size() - 1);
        }

    }
    private void print(List<String> blocks) {
        for (String s : blocks) {
            System.out.println(s);
        }
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        ValidIfBlocks test = new ValidIfBlocks();
        test.validIfBlocks(3);
    }
}
