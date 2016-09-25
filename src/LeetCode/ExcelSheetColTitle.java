package LeetCode;

/**
 * Created by yuliu on 9/15/16.
 * 这道题就是26进制 就是取余数
 */
public class ExcelSheetColTitle {
    public String convertToTitle(int n) {//n=28 AB
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            char c = (char) ('A' + (n - 1) % 26);//c是A＋ 2
            sb.append(c);
            n = (n - 1) / 26;
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]) {
        ExcelSheetColTitle test = new ExcelSheetColTitle();
        System.out.print(test.convertToTitle(28));

    }
}
