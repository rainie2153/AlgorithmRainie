package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 8/26/16.
 */
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] c = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(c, sb, 0, result, strs);
        return result;
    }
    public void dfs(char[] c, StringBuilder sb, int index, List<String> result, String[] strs) {
        if (index == c.length) {
            result.add(sb.toString());
            return;
        }
        int i = c[index] - '2';
        String pad = strs[i];//pad对应一个abc 一个def

        for (int j = 0; j < pad.length(); j++) {
            sb.append(pad.charAt(j));//a//d
            dfs(c, sb, index + 1, result, strs);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public static void main(String args[]) {
        LetterCombinationsPhoneNumber test = new LetterCombinationsPhoneNumber();
        System.out.print(test.letterCombinations("234"));
    }
}
