package Important;

/**
 * Created by yuliu on 8/27/16.
 */
public class DivideTwoInteger {
//    public int divide(int dividend, int divisor) {
//        long a = Math.abs((long) dividend);
//        long b = Math.abs((long) divisor);
//
//        long ret = 0;
//        while (a >= b) {
//            for (long tmp = b, cnt = 1; a >= tmp; tmp <<= 1, cnt <<= 1) {
//                ret += cnt;
//                a -= tmp;
//            }
//        }
//
//        ret = (((dividend ^ divisor) >> 31) & 1) == 1 ? -ret : ret;
//        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
//            return Integer.MAX_VALUE;
//        }
//        return (int) ret;
//    }
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int ret = 0;
        while(a >= b) {
            for (long tmp = b, cnt = 1; a >= tmp; cnt <<= 1, tmp <<= 1) {
                ret += cnt;
                a -= tmp;
            }
        }
        ret = (((a ^ b) >> 31) & 1) == 0 ? ret : -ret;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ret;
    }
    public static void main(String args[]) {
        DivideTwoInteger test = new DivideTwoInteger();
        System.out.print(test.divide(15, 3));
        System.out.print(15 ^ 3);
    }
}
