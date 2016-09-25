package LeetCode;

/**
 * Created by yuliu on 7/16/16.
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long ret = 0;
        while (a >= b) {
            for (long tmp = b, cnt = 1; a >= tmp; ret <<= 1, cnt <<= 1) {
                ret += cnt;
                a -= tmp;
            }
        }

        ret = (((dividend ^ divisor) >> 31) & 1) == 1 ? -ret : ret;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ret;
    }
    public static void main(String args[]) {
        Divide test = new Divide();
        System.out.println(test.divide(21, 7));
    }
}
