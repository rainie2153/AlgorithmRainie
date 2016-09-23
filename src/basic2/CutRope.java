package basic2;

/**
 * Created by yuliu on 6/26/16.
 */
public class CutRope {
    public int maxProduct(int length) {
        int[] array =  new int[length + 1];
        if (length == 2) return 1;
        if (length > 2) {

            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i < array.length; i++) {
                for (int j = 1; j <= i/2; j++) {
                    array[i] = Math.max(array[i], j*Math.max(i - j, array[i - j]));
                }
            }
        }System.out.print(array[length]);
        return array[length];
        // Write your solution here.
        //return 0;
    }

    public static void main(String args[]) {
        CutRope test = new CutRope();
        test.maxProduct(4);
        //System.out.print(test);
    }
}
