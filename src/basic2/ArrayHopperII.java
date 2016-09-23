package basic2;

/**
 * Created by yuliu on 6/26/16.
 */
public class ArrayHopperII {
    public int minJump(int[] array) {
        int length = array.length;
        int[] minJump = new int[length];//record min number of jumps from 0 to each of the indices.
        minJump[0] = 0;
        for (int i = 1; i < length; i++) {
            minJump[i] = -1;//initialized as unreachable
            for(int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j]!= -1) {
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }System.out.print(minJump[length - 1]);
        return minJump[length - 1];
    }


    public static void main(String args[]) {
        ArrayHopperII test = new ArrayHopperII();
        int[] input = {2, 3, 1, 1, 2};
        test.minJump(input);
    }
}
