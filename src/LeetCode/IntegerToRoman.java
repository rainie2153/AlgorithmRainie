package LeetCode;

/**
 * Created by yuliu on 8/25/16.
 */
public class IntegerToRoman {
//    public String intToRoman(int num) {
//        String M[] = {"", "M", "MM", "MMM"};
//        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    //    }
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i < values.length; i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main (String args[]) {
        IntegerToRoman test = new IntegerToRoman();
        System.out.println(test.intToRoman(1234));
        String s = null;
        System.out.println(s.valueOf(s));
    }
}
