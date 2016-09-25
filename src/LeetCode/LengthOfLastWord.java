package LeetCode;

/**
 * Created by yuliu on 8/30/16.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s == " ") {
            return 0;
        }
        String[] strs = s.split(" ");
        String last = strs[strs.length - 1];
        return last.length();
    }
    public static void main(String args[]) {
        LengthOfLastWord test = new LengthOfLastWord();
        System.out.print(test.lengthOfLastWord("    I love you "));
    }

}
