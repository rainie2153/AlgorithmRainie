package LeetCode;

/**
 * Created by yuliu on 9/1/16.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return true;
        }
        char res = s2.charAt(0);
        for (int i = 1; i < s2.length(); i++) {
            res = (char) (res ^ s2.charAt(i));
        }
        for (int i = 0; i < s1.length(); i++) {
            res = (char) (res ^ s1.charAt(i));
        }
        if (res != 0) {
            return false;

        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
        }
        return false;
    }
//上面答案是错因为recursion的base case不能这么写,他每次check 的string都是
    public boolean isScramble2(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) if (letters[i] != 0) return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble2(s1.substring(0,i), s2.substring(0,i))
                    && isScramble2(s1.substring(i), s2.substring(i))) return true;
            if (isScramble2(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble2(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
    public static void main(String args[]) {
        ScrambleString test = new ScrambleString();
        //test case1:"great","taerg"
        //test case2:"abcd", "bdac"  这种不是true 是false
        System.out.print(test.isScramble("abcd", "cdab"));
    }
}
