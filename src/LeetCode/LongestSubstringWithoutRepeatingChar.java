package LeetCode;//Given a string find the length of the longest substring without repeating characters.

import java.util.HashMap;

/**
 * Created by yuliu on 8/24/16.
 */
//fast pointer is used to explore
//pwwkew   wke只要遇到重复的w先删除他以及所有的他,然后slow 加上删除的次数
    //abcdwwwefghw
    //dvdf
public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
//        int slow = 0;
//        int longest = 0;
//        char[] arr = s.toCharArray();
//        Set<Character> set = new HashSet<>();
//        for (int fast = 0; fast < s.length(); ) {
//            if (set.contains(arr[fast])) {
//                set.remove(arr[slow]);
//                slow++;
//            } else {
//                set.add(arr[fast]);
//                fast++;
//            }
//            longest = Math.max(longest, fast - slow);
//        }
//        return longest;
//    }
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j);
        }
        return max;
    }
    public static void main(String args[]) {
        LongestSubstringWithoutRepeatingChar test = new LongestSubstringWithoutRepeatingChar();
        String s = "dvdf";
        System.out.print(test.lengthOfLongestSubstring(s));
    }
}

