package LeetCode;

/**
 * Created by yuliu on 8/30/16.
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int digitA = i < 0 ? 0 : a.charAt(i) - '0';
            int digitB = j < 0 ? 0 : b.charAt(j) - '0';
            sb.insert(0, (digitA + digitB + carry) % 2);
            carry = (digitA + digitB + carry) / 2;
            i--;
            j--;
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        AddBinary test = new AddBinary();
        System.out.print(test.addBinary("110", "101"));
    }
}
