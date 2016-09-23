package Important;

/**
 * Created by yuliu on 7/6/16.
 */
public class PlusOne {
    public int[] res(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else digits[i]++;
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void swapFunction(int a, int b) {

        //System.out.println("Before swapping(Inside), a = " + a
       // + " b = " + b);
        // Swap n1 with n2
        int c = a;
        a = b;
        b = c;

        //System.out.println("After swapping(Inside), a = " + a
       // + " b = " + b);
    }

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        int[] input = {1,0};
        test.res(input);

//        int a = -60;	/* 60 = 0011 1100 */
//        int b = 13;	/* 13 = 0000 1101 */
//        int c = 0;
//
//        c = a & b;       /* 12 = 0000 1100 */
//        System.out.println("a & b = " + c );
//
//        c = a | b;       /* 61 = 0011 1101 */
//        System.out.println("a | b = " + c );
//
//        c = a ^ b;       /* 49 = 0011 0001 */
//        System.out.println("a ^ b = " + c );
//
//        c = ~a;          /*-61 = 1100 0011 */
//        System.out.println("~a = " + c );
//
//        c = a << 2;     /* 240 = 1111 0000 */
//        System.out.println("a << 2 = " + c );
//
//        c = a >> 2;     /* 15 = 1111 */
//        System.out.println("a >> 2  = " + c );
//
//        c = a >>> 2;     /* 15 = 0000 1111 */
//        System.out.println("a >>> 2 = " + c );

//        String str = "abcde";
//       // String substr = "abcd";
//        //System.out.println(str.lastIndexOf(substr));
//        System.out.print(str.getBytes());


            int a = 30;
            int b = 45;

            System.out.println("Before swapping, a = " +
                    a + " and b = " + b);

            // Invoke the swap method
            swapFunction(a, b);
            System.out.println("\n**Now, Before and After swapping values will be same here**:");
            System.out.println("After swapping, a = " +
                    a + " and b is " + b);
        for(int i=0; i<args.length; i++){
            System.out.println("args[" + i + "]: " +
                    args[i]);
        }
        }





}
