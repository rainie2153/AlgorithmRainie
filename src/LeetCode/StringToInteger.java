package LeetCode;

/**
 * Created by yuliu on 8/25/16.
 */
//consider 1.空格
    //2.有+-号的话 要intepret them as 一个数值
    //3.除了数字外可以有chracter
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        int start = 0;
        int sign = 1;

        if (str.charAt(start) == '-') {
            sign = -1;
            start++;
        } else if (str.charAt(start) == '+') {
            sign = 1;
            start++;
        }

        long res = 0;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            int digit = c - '0';
            res = res * 10 + digit;
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        res = res * sign;
        res = res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        res = res < Integer.MIN_VALUE ? Integer.MIN_VALUE : res;
        return (int) res;
    }

    public static void main(String args[]) {
        StringToInteger test = new StringToInteger();

        System.out.print(test.myAtoi("-123"));
    }
}
