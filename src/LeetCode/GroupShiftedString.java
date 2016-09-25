package LeetCode;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 7/28/16.
 */
public class GroupShiftedString {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            String key = getKey(str.toCharArray());
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> ans = entry.getValue();
            Collections.sort(ans);
            res.add(ans);
        }

        return res;
    }

    public String getKey(char[] str) {
        if (str.length == 0) return new String(str);
        int diff = str[0] - 'a';
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i] - diff >= 'a' ? (char) (str[i] - diff) : (char) (str[i] - diff + 26);
        }
        return new String(str);

    }

    public static void main(String args[]) {
        GroupShiftedString test = new GroupShiftedString();
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.print(test.groupStrings(input));
    }
}
