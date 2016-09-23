package Important;

/**
 * Created by yuliu on 8/2/16.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for (int i = 5; i <= n; i++) {
            dp[i] = 3 * Math.max(i - 3, dp[i - 3]);
        }
        return dp[n];
    }
    public static void main(String args[]) {
        IntegerBreak test = new IntegerBreak();
        System.out.print(test.integerBreak(7));
    }
}

