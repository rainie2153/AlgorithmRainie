package LeetCode;

/**
 * Created by yuliu on 8/10/16.
 */
public class Sqrt {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 1, right = x;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
    public static void main(String args[]) {
        Sqrt test = new Sqrt();
        System.out.print(test.mySqrt(81));
    }
}
