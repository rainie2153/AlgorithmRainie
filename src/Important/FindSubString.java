package Important;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 8/27/16.
 */
public class FindSubString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }

        int n = s.length();//提出来的字符的最长的长度
        int len = words[0].length();//boo的长度

        //build map
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }

        //len * words.length是所有words加起来的总共的长度
        for (int i = 0; i <= n - len * words.length; i++) {//外层n最长
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);//截出string在map中出现的次数
                    if(count == 1) {
                        copy.remove(str);
                    } else {
                        copy.put(str, count - 1);
                    }
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else break;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        FindSubString test = new FindSubString();
        String s = "barfoothefoobarman";
        String[] words = {"bar", "foo"};
        System.out.println(test.findSubstring(s, words));
    }

}
