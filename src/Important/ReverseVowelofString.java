package Important;

/**
 * Created by yuliu on 8/2/16.
 */
public class ReverseVowelofString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(array[left] + "")) left++;
            while (left < right && !vowels.contains(array[right] + "")) right--;
            swap(array, left++, right--);
        }

        return new String(array);
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String args[]) {
        ReverseVowelofString test = new ReverseVowelofString();
        String input = "leetcode";
        System.out.print(test.reverseVowels(input));
    }
}
