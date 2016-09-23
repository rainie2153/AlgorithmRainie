package Important;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 9/6/16.
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid
 * dictionary word
 * Return all possible sentences.
 * Method : DFS
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }
    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String sub = s.substring(word.length());
                List<String> subList = dfs(sub, wordDict, map);
                for (String subres : subList) {
                    res.add(word + (subres.length() == 0 ? "" : " ") + subres);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    public static void main(String args[]) {
        WordBreakII test = new WordBreakII();
        Set<String> set = new HashSet<>();
        set.add("dog");
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        test.wordBreak("catsanddog", set);
    }
}
