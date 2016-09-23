package Important;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 8/29/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            String key = getKey(str);//如果这个str是同样的character组成的不同的str他有个他们自己的key比如ate是key成员有(tae,eta等)
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

    private String getKey(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
