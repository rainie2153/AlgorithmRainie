package Important;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 8/27/16.
 */
public class SubstringWithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        //first build toFind map
        int m = words.length;
        int n = words[0].length();
        Map<String, Integer> toFind = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (toFind.containsKey(words[i])) {
                toFind.put(words[i], toFind.get(words[i]) + 1);
            } else {
                toFind.put(words[i], 1);
            }
        }

        //travese every single string
        for (int i = 0; i < n; i++) {
            Map<String, Integer> found = new HashMap<String, Integer>();
            int start = i;
            int count = 0;

            for (int j = i; j <= s.length() - n; j += n) {
                String stub = s.substring(j, j + n);
                if (toFind.containsKey(stub)) {
                    if (found.containsKey(stub)) {
                        found.put(stub, found.get(stub) + 1);
                    } else found.put(stub, 1);

                    count++;

                    while (found.get(stub) > toFind.get(stub)) {
                        String left = s.substring(start, start + n);
                        found.put(left, found.get(left) - 1);
                        count--;
                        start += n;
                    }

                    if (count == words.length) {
                        res.add(start);
                        String left = s.substring(start, start + n);
                        found.put(left, found.get(left) - 1);
                        count--;
                        start += n;
                    }
                } else {
                    found.clear();
                    count = 0;
                    start = j + n;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        SubstringWithConcatenationofAllWords test = new SubstringWithConcatenationofAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"bar", "foo"};
        test.findSubstring(s, words);
    }
}
