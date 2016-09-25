package LeetCode;

/**
 * Created by yuliu on 8/2/16.
 */
public class isPowerOfTwo {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num - 1)) == 0 && (num - 1) % 3 == 0;
        //return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
    public static void main(String[] args){
        isPowerOfTwo tmp = new isPowerOfTwo();
        System.out.println(tmp.isPowerOfFour(4));
    }
}
