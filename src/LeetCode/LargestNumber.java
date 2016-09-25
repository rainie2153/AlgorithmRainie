package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yuliu on 7/25/16.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] + "";
        }
        Arrays.sort(array, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (String str : array) {
            sb.append(str);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return new String(sb);
    }

    class MyComparator implements Comparator<String> {
        public int compare(String one, String two) {
            String a = one + two;
            String b = two + one;
            return -a.compareTo(b);

        }
    }
    public static void main (String[] args) {
        LargestNumber test = new LargestNumber();
        int[] input = new int[] {1,2,3,4,5};
        test.largestNumber(input);
    }
}
