package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/28/16.
 */
public class DuiChenNumberIII {
    char[][] pairs = new char[][]{{'0','0'},{'1','1'},{'8','8'},{'6','9'},{'9','6'}};

    public int strobogrammaticInRange(String low, String high) {
        if(low == null || high == null || low.length() == 0 || high.length() == 0){
            return 0;
        }
        List<String> result = generateStrobo(low, high);
        return result.size();
    }
    private List<String> generateStrobo(String low, String high){
        List<String> result = new ArrayList<>();
        for(int i = low.length(); i<= high.length(); i++){
            generate(0, i - 1, new char[i], low, high, result);
        }
        return result;
    }

    private void generate(int start, int end, char[] num, String low, String high, List<String> result){
        if(start > end){
            String answer = new String(num);
            if((answer.length() == low.length() && answer.compareTo(low) < 0)
                    || (answer.length() == high.length() && answer.compareTo(high) > 0)){
                return;
            }
            result.add(answer);
            return;
        }
        for(char[] pair : pairs){
            char first = pair[0];
            char last = pair[1];
            num[start] = first;
            num[end] = last;
            //when start == end, the digit has to be the same
            //also the first digit cannot be 0
            if((start == end && first != last) || (num.length > 1 && num[0] == '0')){
                continue;
            }
            generate(start + 1, end - 1, num, low, high, result);
        }

    }

    public static void main(String args[]) {
        DuiChenNumberIII test = new DuiChenNumberIII();
        System.out.print(test.strobogrammaticInRange("30", "88"));
    }
}
