package Important;

/**
 * Created by yuliu on 7/28/16.
 */
public class WordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ind1 = -1, ind2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {
                if (!word1.equals(words[i])) continue;
                if (ind1 == -1) ind1 = i;
                else if (ind2 == -1) {
                    ind2 = i;
                    min = Math.min(min, ind2 - ind1);
                } else {
                    ind1 = ind2;
                    ind2 = i;
                    min = Math.min(min, ind2 - ind1);
                }
            } else {
                if (word1.equals(words[i])) ind1 = i;
                if (word2.equals(words[i])) ind2 = i;
                if (ind1 != -1 && ind2 != -1) {
                    min = Math.min(min, Math.abs(ind1 - ind2));
                }
            }
        }
        return min;
    }
    public static void main(String args[]) {
        WordDistanceIII test = new WordDistanceIII();
        String[] words = {"practice", "makes", "perfect", "makes", "makes"};

        String word1 = "makes";
        String word2 = "makes";
        System.out.print(test.shortestWordDistance(words, word1, word2));
    }
}
