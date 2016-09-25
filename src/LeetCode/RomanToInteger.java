package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 8/25/16.
 用一个hashmap来存一个罗马数字对应的数字*/
public class RomanToInteger {
    public int romanToInteger(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        res += map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            char prev = s.charAt(i + 1);
            char cur = s.charAt(i);
            if (map.get(cur) < map.get(prev)) {
                res -= map.get(cur);
            } else res += map.get(cur);
        }
        return res;
    }

    public static void main (String args[]) {
        RomanToInteger test = new RomanToInteger();
        System.out.println(test.romanToInteger("MCCXXXIV"));
    }
}
