package Important; /**
 * Created by yuliu on 7/28/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                List<Integer> list = map.get(words[i]);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int minDist = Integer.MAX_VALUE;
        int m = list1.size(), n = list2.size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            minDist = Math.min(minDist, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) i++;
            else j++;
        }
        return minDist;
    }


    public static void main(String args[]) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance test = new WordDistance(words);
        String word1 = "coding";
        String word2 = "makes";
        System.out.print(test.shortest(word1, word2));
    }

}
