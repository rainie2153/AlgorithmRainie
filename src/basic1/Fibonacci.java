package basic1;

/**
 * Created by yuliu on 3/11/16.
 */
public class Fibonacci {
    public long fibonacci(int K) {
        if (K <= 0) return 0;
        if (K == 1) return 1;
        long a = 0;
        long b = 1;
        while (K > 1) {
            long output = a + b;
            a = b;
            b = output;
            K = K - 1;
        }
        return b;

    }

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();
        int K = 6;
        System.out.println(solution.fibonacci(K));
    }
}
