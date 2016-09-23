package Important;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 7/29/16.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 != 0 && flag) {
                return false;
            } else if (value % 2 != 0) {
                flag = true;//单身狗
            }
        }
        return true;
    }

    public static void main(String args[]) {
        PalindromePermutation test = new PalindromePermutation();
        System.out.print(test.canPermutePalindrome("aabbcdef"));
    }

}
