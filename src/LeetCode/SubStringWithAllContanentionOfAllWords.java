package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 7/16/16.
 */
public class SubStringWithAllContanentionOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();

        if (s == null || s.length() == 0 || words.length == 0) return res;

        //Build target map for words
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        int len = words[0].length();
        int num = words.length; //total matches needed

        //start from different index
        for (int i = 0; i < len; i++) {
            int start = i; //record the current starting point
            int count = 0; //record number of matchs
            Map<String, Integer> found = new HashMap<String, Integer>(); //record the matches we've found from start to so far
            for (int j = i; j <= s.length() - len; j += len) {
                //get the substring from s
                String sub = s.substring(j, j + len);
                if (map.containsKey(sub)) {
                    if (found.containsKey(sub)) {
                        //found.get(sub) is at most map.get(sub) + 1
                        found.put(sub, found.get(sub) + 1);
                    } else {
                        found.put(sub, 1);
                    }
                    count++;

                    while (found.get(sub) > map.get(sub)) {
                        String temp = s.substring(start, start + len);
                        found.put(temp, found.get(temp) - 1);
                        count--;
                        start += len;
                    }

                    if (count == num) {
                        res.add(start);
                        String temp = s.substring(start, start + len);
                        found.put(temp, found.get(temp) - 1);
                        count--;
                        start += len;
                    }
                } else {
                    //doesn't match, clear the hashmap
                    found.clear();
                    count = 0;
                    start = j + len;
                }
            }
        }
        return res;

    }
    public static void main(String args[]) {
        SubStringWithAllContanentionOfAllWords test = new SubStringWithAllContanentionOfAllWords();
        String[] words = {"foo", "bar"};
        test.findSubstring("bareforefooxyzbarfoofalfjd", words);
    }
}
