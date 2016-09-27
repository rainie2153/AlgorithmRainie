package mianjing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuliu on 9/24/16.
 */
public class RemoveInvalidParenthesis {
    //第一题：这个是只需要返回一个解
    public String removeInvalid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = removeRight(s);
        s = removeLeft(s);
        return s;
    }

    private String removeRight(String s) {//从左往右扫 去掉右括号
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
                sb.append(c);
            } else if (c == ')') {
                if (count > 0) {
                    count--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    private String removeLeft(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                count++;
                sb.append(c);
            } else if (c == '(') {
                if (count >0) {
                    count--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }

        }
        return sb.reverse().toString();
    }

    //第二题 需要返回多个解
    //Return all possible results by removing min # of 无效括号
    public List<String> remove(String s) {
        int rmLeft = 0;//indicates the # of ( we need to remove
        int rmRight = 0;//indicates the # of ) we need to remove
        //先计算下到底多少要remove的左右括号
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                rmLeft++;
            } else if (c == ')'){
                if (rmLeft == 0) {
                    rmRight++;
                } else {
                    rmLeft--;
                }
            }
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();

        dfs(0, rmLeft, rmRight, 0, s, sb, set);

        return new ArrayList<>(set);

    }

    public void dfs(int index, int rml, int rmr, int open, String s, StringBuilder sb, Set<String> res) {
        if (index == s.length() && rml == 0 && rmr == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (index == s.length() || rml < 0 || rmr < 0 || open < 0) {
            return;
        }

        char c = s.charAt(index);
        if (c == '(') {
            dfs(index + 1, rml - 1, rmr, open, s, sb, res); //we don't add it 不加第一个character就是删了第一个看看能不能valid 所以 rml - 1
            sb.append(c);
            dfs(index + 1, rml, rmr, open + 1, s, sb, res); //we add it如果加上了第一个"("open多1个
            sb.deleteCharAt(sb.length() - 1);
        } else if (c == ')') {
            dfs(index + 1, rml, rmr - 1, open, s, sb, res); //we don't add it
            sb.append(c);
            dfs(index + 1, rml, rmr, open - 1, s, sb, res); //we add it加了一个")"则open-1
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(c);
            dfs(index + 1, rml, rmr, open, s, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String args[]) {
        RemoveInvalidParenthesis test = new RemoveInvalidParenthesis();
        System.out.println(test.remove("(a)())()"));
        String s = "a,b,c,";
        String[] num = s.split(",");
        System.out.println("ttt");
    }
}
