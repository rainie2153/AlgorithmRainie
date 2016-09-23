package Important;

/**
 * Created by yuliu on 8/25/16.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x == 0) return 0;
        if (x > 0) {
            return reverseHelper(x);
        }
        if (x < 0) {
            return -reverseHelper(-x);
        }
        return 0;
    }
    public int reverseHelper(int x) {
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE) {
                res = 0;
            }
        }
        return (int)res;
    }
    public static void main(String args[]) {
        ReverseInteger test = new ReverseInteger();

        System.out.print(test.reverse(-2147483641));
    }
}
