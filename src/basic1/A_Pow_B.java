package basic1;

/**
 * Created by yuliu on 3/11/16.
 */
public class A_Pow_B {
    public long a_pow_b (long a, int b) {
        if (a == 0 && b <= 0) {
            return 0;//or throw exception
        }
        if (a != 0 && b == 0) {
            return 1;
        }
        if (a == 0 && b > 0) {
            return 0;
        }
        if (a == 0 || b == 0) {
            return 1;
        }
        if (b < 0) {
            return 1 / powerPositive(a, -b);
        } else {
            return powerPositive(a, b);
        }
    }
    private long powerPositive(long a, int b) {
        if (b == 0) {
            return 1;
        }
        long temp = powerPositive(a, b / 2);
        if (b % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * a;
        }
    }

    public static void main(String[] args) {
        A_Pow_B solution = new A_Pow_B();
        int a = 2;
        int b = 1;
        System.out.println(solution.a_pow_b(2,1));
    }
}
