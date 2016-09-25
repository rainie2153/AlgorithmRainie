package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuliu on 9/5/16.
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space- separated sequence of
 * one or more dictionary words
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
    public static void main(String args[]) {
        WordBreak test = new WordBreak();
        Set<String> worddict = new HashSet<>();
        worddict.add("leet");
        worddict.add("code");
        test.wordBreak("leetcode",worddict);
    }
}
