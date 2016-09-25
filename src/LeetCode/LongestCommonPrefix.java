package LeetCode;

/**
 * Created by yuliu on 8/25/16.
 */
public class LongestCommonPrefix {
    //Approach1:水平扫
//    public String longestCommonPrefix(String[] strs) {
//        if(strs == null || strs.length == 0) {
//            return "";
//        }
//        String prefix = strs[0];
//        for (int i = 0; i < strs.length; i++) {
//            while (strs[i].indexOf(prefix) == -1) {//说明找到在非0原来位置另外一个地方还有一个prefix 这样的string
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) {
//                    return "";
//                }
//            }
//        }
//        return prefix;
//    }
    //Approach2: 垂直扫
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        for (int i = 0; i < strs[0].length(); i++) {//第一个数的长度
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != c) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//        return strs[0];//如果只有一个元素 或者什么都没有的话 就进入不了for loop
//    }
    //Approach3: Important.Divide and conquer
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return helper(strs, 0, strs.length - 1);
    }
    private String helper(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = l + (r - l) / 2;
            String lcpLeft = helper(strs, l, mid);
            String lcpright = helper(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpright);
        }
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if(left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }


    public static void main (String args[]) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] stringarr = {"leetcode", "leetco", "leet", "le"};
        String[] stringarr1 = {"a"};
        System.out.println(stringarr1.length);
        System.out.println(test.longestCommonPrefix(stringarr));
    }
}
