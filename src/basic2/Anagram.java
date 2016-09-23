package basic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuliu on 6/19/16.
 */public class Anagram {
    public static boolean isAnagram(String s, String l){
        char[] s1 = s.toCharArray();
        char[] l1 = l.toCharArray();
        Arrays.sort(s1);//ab
        Arrays.sort(l1);//abccdd
        for(int i=0; i<s1.length; i++){
            if(s1[i] != l1[i])
                return false;
        }
        return true;
    }

    List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<Integer>();
        if(l.length() == 0)
            return result;
        for(int i=0; i<=l.length()-s.length(); i++){
            if(isAnagram(l.substring(i,i+s.length()), s))
                result.add(i);
        }
        // Write your solution here.
        return result;
    }

    public static void main(String[] args) {
        AnagramsShortInLong test = new AnagramsShortInLong();
        String s = "ab", l = "abcbabc";
        test.allAnagrams(s, l);

    }
}
