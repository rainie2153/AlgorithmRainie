package LeetCode;

/**
 * Created by yuliu on 8/3/16.
 */
public class VerifyPreorderStr {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true;
        String[] data = preorder.split(",");

        int depth = 0;
        for (int i = 0; i < data.length; i++) {
            String curr = data[i];
            if (curr.equals("#")) {
                depth--;
                if (i != data.length - 1 && depth < 0) return false;
            } else {
                depth++;
            }
        }

        return depth == -1;
    }
    public static void main(String args[]) {
        VerifyPreorderStr test = new VerifyPreorderStr();
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.print(test.isValidSerialization(str));
    }
}
