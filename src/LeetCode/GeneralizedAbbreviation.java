package LeetCode;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 8/9/16.
 */
public class GeneralizedAbbreviation {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> temp = entry.getValue();
            Collections.sort(temp);
            res.add(temp);
        }
        return res;
    }

    public String getKey(String str) {
        if (str == null || str.length() == 0) return str;
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
    public static void main(String args[]) {
        GeneralizedAbbreviation test = new GeneralizedAbbreviation();
        String[] nums = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(test.groupAnagrams(nums));
    }

}
