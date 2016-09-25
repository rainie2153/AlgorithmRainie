package LeetCode;

/**
 * Created by yuliu on 8/30/16.
 */
public class PlusOneI {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int res = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            res = digits[i] + carry;
            carry = res / 10;
            digits[i] = res % 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] newArray = new int[digits.length + 1];
        if (carry == 1) {
            newArray[0] = 1;
        }
        return newArray;
    }
    public static void main(String[] args) {
        PlusOneI test = new PlusOneI();
        int[] input = {1, 9};
        System.out.print(test.plusOne(input));
    }
}
