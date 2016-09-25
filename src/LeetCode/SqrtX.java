package LeetCode;

/**
 * Created by yuliu on 8/31/16.
 */
public class SqrtX {
    public int mySqrt(int x) {//16
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;//1 + (16 - 1) / 2 = 8
            if (mid <= x / mid) {
                left = mid + 1; //应该往更大的数字去找
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
}
