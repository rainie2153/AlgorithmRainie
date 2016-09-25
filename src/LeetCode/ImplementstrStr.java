package LeetCode;

/**
 * Created by yuliu on 8/27/16.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {//就是在haystack里找needle
        if(haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        char[] explore = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for(int i = 0; i < explore.length - target.length + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length; j++) {
                if(explore[j + i] != target[j]) {
                    break;
                }
            }
            if (j == target.length) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        ImplementstrStr test = new ImplementstrStr();
        String big = "abcleetcode";
        String small = "leet";
        System.out.print(test.strStr(big, small));
    }
}
