package LeetCode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yuliu on 7/18/16.
 */
public class PermutationI {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) return result;
        char[] c = set.toCharArray();
        helper(c, 0, result);
        return result;
    }
    private void helper(char[] chararray, int index, List<String> result) {
        //terminate condition
        if (index == chararray.length) {
            result.add(new String(chararray));
            return;
        }
        for (int i = index; i < chararray.length; i++) {
            swap(chararray, index, i);
            helper(chararray, index + 1, result);
            swap(chararray, index ,i);
        }
    }
    private void swap(char[] c, int left, int right) {
        char tmp = c[left];
        c[left] = c[right];
        c[right] = tmp;
    }
    public static void main(String args[]) {
        PermutationI test = new PermutationI();
        System.out.print(test.permutations("abc"));
    }

}
