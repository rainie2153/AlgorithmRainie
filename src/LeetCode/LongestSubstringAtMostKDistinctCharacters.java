package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 8/2/16.
 */
public class LongestSubstringAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            while (map.size() > k && slow < s.length()) {
                char sc = s.charAt(slow);
                map.put(sc, map.get(sc) - 1);
                if (map.get(sc) == 0) {
                    map.remove(sc);
                }
                slow++;
            }

            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
    public static void main(String args[]) {
        LongestSubstringAtMostKDistinctCharacters test = new LongestSubstringAtMostKDistinctCharacters();
        System.out.print(test.lengthOfLongestSubstringKDistinct("eeerdey", 3));
    }
}

