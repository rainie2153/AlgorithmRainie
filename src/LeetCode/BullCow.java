package LeetCode;

/**
 * Created by yuliu on 7/31/16.
 */
public class BullCow {
    public String getHint(String secret, String guess) {
        int[] map = new int[10]; //store the digit from 0 to 9
        //build the map
        for (int i = 0; i < guess.length(); i++) {
            int g = (int) (guess.charAt(i) - '0');
            map[g]++;
        }

        int bulls = 0;//store the bulls
        int match = 0;//store the bulls + cows
        for (int i = 0; i < secret.length(); i++) {
            int s = (int) (secret.charAt(i) - '0');
            int g = (int) (guess.charAt(i) - '0');
            if (s == g) bulls++; //only need to advance the bulls
            if (map[s] > 0) {
                map[s]--;
                match++;
            }
        }
        return String.valueOf(bulls) + 'A' + String.valueOf(match - bulls) + 'B';
    }
    public static void main(String args[]) {
        BullCow test = new BullCow();
        System.out.print(test.getHint("1807", "7810"));
    }
}
