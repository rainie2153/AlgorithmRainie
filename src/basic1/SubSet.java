package basic1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 4/24/16.
 */
public class SubSet {
    public List<String> subset(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }

        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);

        for (String s : result) {
            System.out.println(s);
        }
        return result;
    }

    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        for (int i = index; i < set.length; i++) {
            sb.append(set[i]);
            helper(set, sb, i + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main (String[] args) {
        SubSet test = new SubSet();
        String s = "abc";
        test.subset(s);
    }

}


