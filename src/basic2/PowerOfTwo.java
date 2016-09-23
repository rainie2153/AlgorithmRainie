package basic2;

/**
 * Created by yuliu on 6/21/16.
 */
public class PowerOfTwo {
    public boolean isPowerofTwo(int number) {
        if (number <= 0) {
            System.out.print(false);
            return false;
        }
        while ((number & 1) == 0) {
            number >>>= 1;
        }

        if (number == 1) {
            System.out.print(true);
            return true;

        } else System.out.print(false);
        return false;
    }


    public static void main(String[] args) {
        PowerOfTwo test = new PowerOfTwo();
        test.isPowerofTwo(8);
    }

}

