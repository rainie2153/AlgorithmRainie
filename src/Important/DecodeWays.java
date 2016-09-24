package Important;

/**
 * Created by yuliu on 9/2/16.
 *///a message containing letters from A-Z is being encoded to numbers
    //'A'- 1
    //'B'- 2
    //'Z'- 26
    //Given an encoded msg containing digits, determine the total # of ways to decode it
public class DecodeWays {
    public int decodeWays(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] M = new int[s.length()];
        if (s.charAt(0) == 0) {
            return 0;
        }
        M[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (cur >= '1' && cur <= '9') {
                M[i] += M[i - 1];
            }
            if (prev == '1' || prev == '2' && cur <= '6') {
                if (i == 1) {
                    M[i] += 1;
                } else {
                    M[i] += M[i - 2];
                }
            }
        }
        return M[s.length() - 1];
    }
    public static void main(String args[]) {
        DecodeWays test = new DecodeWays();
        System.out.print(test.decodeWays("27"));
    }


}
