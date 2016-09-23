package basic2;

/**
 * Created by yuliu on 6/26/16.
 */
public class ArrayHopper {//canJump[i] means from index 0 can jump to index i.
    public boolean canJump(int[] array) {
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                //if index j is reachable from index 0 , and from index j. It is possible to jump to index i
                if (canJump[j]&&array[j] + j >= i) {
                    canJump[i] = true;
                    break;//loop
                }
            }
        }System.out.print(canJump[array.length - 1]);
        return canJump[array.length - 1];
    }
    public static void main(String args[]) {
        ArrayHopper test = new ArrayHopper();
        int[] input = {1, 3, 0, 0, 0};
        test.canJump(input);
        //int res = true && 7;
        //System.out.print(res);
        String Str = new String("            Welcome       to       Tutorialspoint.com   ");

        System.out.print("Return Value :" );
        System.out.println(Str.trim() );
    }
}
