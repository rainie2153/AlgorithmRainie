package basic2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliu on 6/19/16.
 */
public class AnagramsShortInLong {
    public List<Integer> allAnagrams(String s, String l) {//demo s = "ab", l="abcbac" return 0 and 3
        List<Integer> result = new ArrayList<Integer>();
        if(l.length() == 0 ||s.length() > l.length()) return result;

        Map<Character, Integer> map = countMap(s);//record the count number of a char which is showing distinctly
        int match = 0;
        for(int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if(count != null) {
                map.put(tmp, count - 1);//when a,1 then count-1 count == 0  then we have 'a' matched.
            } else if (count == 1) match ++;//match of distinct character

            if(i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if(count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }

            if(match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        System.out.print(result);
        return result;



    }
    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()){
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        } return map;
    }

    public static void main(String[] args) {
        AnagramsShortInLong test = new AnagramsShortInLong();
        String s = "ab", l = "abcbabc";
        test.allAnagrams(s, l);
    }
}
