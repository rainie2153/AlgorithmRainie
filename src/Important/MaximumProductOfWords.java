package Important;

/**
 * Created by yuliu on 8/9/16.
 */
public class MaximumProductOfWords {
    public int maxProduct(String[] words) {
        int max = 0;
        if (words == null || words.length <= 1) return max;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasCommonLetter(words[i], words[j]))  {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    public boolean hasCommonLetter(String a, String b) {
        boolean[] A = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            A[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (A[b.charAt(i) - 'a']) {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        MaximumProductOfWords test = new MaximumProductOfWords();
        String[] input = {"ab", "abcd"};
        System.out.print(test.maxProduct(input));
    }
}
