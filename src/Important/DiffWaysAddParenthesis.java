package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 7/28/16.
 */
public class DiffWaysAddParenthesis {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null) return res;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> leftRes = diffWaysToCompute(left);
                List<Integer> rightRes = diffWaysToCompute(right);
                for (Integer l : leftRes) {
                    for (Integer r : rightRes) {
                        switch (c) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.parseInt(input));
        return res;
    }

    public static void main(String args[]) {
        DiffWaysAddParenthesis test = new DiffWaysAddParenthesis();
        test.diffWaysToCompute("2*3-4*5");
    }
}
