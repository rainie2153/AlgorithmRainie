package basic2;

/**
 * Created by yuliu on 6/18/16.
 */
public class MissingNumber {
    public int missing (int[] array) {
        int n = array.length + 1;
        //HashSet<Integer> set = new HashSet<Integer>();
        int xor = 0;
        for(int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for(int num: array) {
            xor ^=num;
        }
        System.out.print(xor);

        return xor;

    }
    public static void main (String[] args) {
        MissingNumber test = new MissingNumber();
        int[] array = {1,2,4};
        test.missing(array);
    }
}
