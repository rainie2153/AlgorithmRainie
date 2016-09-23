package basic2;

/**
 * Created by yuliu on 6/20/16.
 */
public class AbbreviationMatching {
    public boolean match (String input, String pattern) {
        return match (input, pattern, 0, 0);
    }
    private boolean match (String s, String t, int si, int ti) {
        //we will find a match only when we run out of s and t at the same time
        if (si == s.length() && ti == t.length()) {
            System.out.print(true);
            return true;
        }
        if (si > s.length() || ti > t.length()) {
            //System.out.print(false);
            return false;
        }
        if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
            if (s.charAt(si) == t.charAt(ti)) {
                return match(s, t, si + 1, ti + 1);
            }
            System.out.print(false);
            return false;
        }
//if the current character in t is a digit and we need to find in total what is the number
        int count = 0;
        while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
            count = count*10 + (t.charAt(ti) - '0');
            ti++;
        }return match(s, t, si + count, ti);
    }
    public static void main(String[] args) {
        AbbreviationMatching test = new AbbreviationMatching();
        String input = "boop", pattern = "b3";
        test.match(input, pattern);
    }
}
