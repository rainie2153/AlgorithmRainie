package LeetCode;

/**
 * Created by yuliu on 7/30/16.
 */
public class Plus {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    public static void main(String[] args) {
        Plus test = new Plus();
        test.getSum(2,5);
    }
}
