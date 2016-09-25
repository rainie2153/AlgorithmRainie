package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 7/30/16.
 */
public class UniqueWordAbbreviation {
    Map<String, String> map = new HashMap<String, String>();
    public void ValidWordAbbr(String[] dictionary) {
        for (String str : dictionary) {
            if (str == null || str.length() <= 2) continue;
            String abbre = getAbbre(str);
            if (!map.containsKey(abbre)) {
                map.put(abbre, str);
            } else if (!map.get(abbre).equals(str)) {
                map.put(abbre, "-1");
            }
        }
    }

    public boolean isUnique(String word) {
        if (word == null || word.length() <= 2) return true;
        String abbre = getAbbre(word);
        if (!map.containsKey(abbre)) return true;
        else return word.equals(map.get(abbre));
    }

    public String getAbbre(String str) {
        return str.charAt(0) + String.valueOf(str.length() - 2) + str.charAt(str.length() - 1);
    }

    public static void main(String args[]) {
        UniqueWordAbbreviation test = new UniqueWordAbbreviation();
        String[] input = {"deer", "door", "cake", "card"};
        //System.out.print(test.getAbbre(input));
    }
}
