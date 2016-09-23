package Important;

/**
 * Created by yuliu on 7/19/16.
 *///这个方法时间复杂度太大了  垃圾!
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        //create target map
        int[] target = new int[256];
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i)]++;
        }
        int[] source = new int[256];
        int match = 0;
        String res = null;
        int slow = 0;
        for (int i = 0; i < s.length(); i++) {
            char fc = s.charAt(i);
            source[fc]++;
            if (source[fc] <= target[fc]) {//说明还没match完
                match++;
            }
            while(slow < s.length() && match == t.length()) {//是说match上了ABC这三个character
                char sc = s.charAt(slow);
                source[sc]--;//从source中减去match上的character出现的次数
                if(source[sc] < target[sc]) {
                    match--;
                    String sub = s.substring(slow, i + 1);
                    if (res == null || res.length() > sub.length()) {
                        res = sub;
                    }
                }
                slow++;
            }
        }
        return res == null ? "" : res;
    }

    public static void main(String args[]) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.print(test.minWindow("ADOBECODEBANC", "ABC"));
    }
}
