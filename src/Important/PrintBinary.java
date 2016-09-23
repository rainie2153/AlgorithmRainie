package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 8/4/16.
 */
public class PrintBinary {
    public void printBinary(int digits, String soFar) {
        List<String> res = new ArrayList<>();
        if (digits == 0) {
            res.add(soFar);
            System.out.print(res);
        } else {
            for (int i = 1; i <= 5; i++) {
               // res.add(Integer.toString(i));
                printBinary(digits - 1, soFar + Integer.toString(i));
                //res.remove(res.size() - 1);

            }
        }
    }
    public static void main(String args[]) {
        PrintBinary test = new PrintBinary();
        test.printBinary(5, "");
    }
}
