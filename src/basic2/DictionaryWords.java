package basic2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuliu on 6/26/16.
 */
public class DictionaryWords {
    public boolean canBreak(String input, String[] dict) {
        Set<String> dictSet = new HashSet<>(Arrays.asList(dict));//意思把dictionary{"bob","cat","rob"}加到dictSet里
        //canBreak[i]means index(i-1) in input, also can be represent the substring(0,i)
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(input.substring(j, i))&&canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        System.out.print(canBreak[canBreak.length - 1]);
        return canBreak[canBreak.length - 1];
    }
//    private Set<String> toSet(String[] dict) {
//        Set<String> set = new HashSet<>();
//        for (String s: dict) {
//            set.add(s);
//        }
//        return set;//toSet function的功能就是如果有S在字典里面就把s加到set里
//    }

    public static void main(String[] args) {
        DictionaryWords test = new DictionaryWords();
        String input = "robbob";
        String[] dict = {"boob","cat","rob", "gc"};
        test.canBreak(input, dict);
    }
}
