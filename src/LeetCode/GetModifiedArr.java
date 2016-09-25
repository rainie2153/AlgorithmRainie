package LeetCode;

/**
 * Created by yuliu on 7/31/16.
 */
public class GetModifiedArr {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {

            int start = update[0];
            int end = update[1];
            int value = update[2];

            res[start] += value;

            if(end + 1 < length)
                res[end + 1] -= value;

        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;

    }
    public static void main(String[] args) {
        GetModifiedArr test = new GetModifiedArr();
        int[][] updates = {{1,  3,  2},
                {2,  4,  3},
                {0,  2, -2}};
        System.out.print(test.getModifiedArray(5, updates));
    }

}
