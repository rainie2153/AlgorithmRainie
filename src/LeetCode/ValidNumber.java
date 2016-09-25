package LeetCode;

/**
 * Created by yuliu on 8/30/16.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '-' || s.charAt(start) == '+') {
            start++;
        }
        boolean num = false;
        boolean eflag = false;
        boolean dotflag = false;
        while (start <= end) {
            char c = s.charAt(start);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == 'e') {
                if (eflag || !num) {
                    return false;
                } else {
                    eflag = true;
                    num = false;
                }
            } else if (c == '.') {
                if (dotflag || eflag) {
                    return false;
                } else {
                    dotflag = true;
                }
            } else if (c == '-' || c == '+') {
                if (s.charAt(start - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            start++;
        }
        return num;
    }
    public static void main(String args[]) {
        ValidNumber test = new ValidNumber();
        System.out.print(test.isNumber("2.10"));
    }
}
