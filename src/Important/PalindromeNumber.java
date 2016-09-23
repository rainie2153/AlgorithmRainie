package Important;

/**
 * Created by yuliu on 8/25/16.
 *///323
public class PalindromeNumber {
    public boolean isPalindrome (int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int digit = digit(x);
        while (digit >= 1) {
            int left = (int) (x / Math.pow(10, digit - 1));
            int right = x % 10;
            if (left == right) {
                x = x - left * (int) Math.pow(10, digit - 1);//323 - 300 =23
                x -= right;//23 - 3 = 20
                x /= 10;//取2
                digit -= 2;
            } else {
                return false;
            }
        }
        return true;
    }
    private int digit(int x) {
        int cnt = 0;
        while(x > 0) {
            x /= 10;
            cnt++;
        }
        return cnt;
    }
    public static void main(String args[]) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.print(test.isPalindrome(632236));
    }
}
