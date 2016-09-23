package Important;

/**
 * Created by yuliu on 7/25/16.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;//*2
            res |= ((n >> i) & 1);
        }
        return res;
    }
    public static void main(String args[]) {
        ReverseBits test = new ReverseBits();

        System.out.print(test.reverseBits(2));
    }

}
