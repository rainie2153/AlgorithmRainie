package mianjing;

import java.util.*;

/**
 * Created by yuliu on 9/26/16.
 */
public class TEstDFS {
    public void dfs(char[] test, StringBuilder sb, int index) {
        if(index == test.length) {

            return;
        }

        char c = test[index];
        sb.append(c);
        dfs(test, sb, index + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
    public String test(char[] test) {
        StringBuilder sb = new StringBuilder();

        dfs(test, sb, 0);
        return sb.toString();
    }
    public static void main(String args[]) {
        TEstDFS w = new TEstDFS();
        String s = "a,b,c";

        System.out.print(w.test(s.toCharArray()));
        List<String> list = Arrays.asList(s.split(","));
        Deque<String> queue = new LinkedList<>();

        queue.addAll(list);
        System.out.print(s.split(","));
        StringBuilder sb = new StringBuilder();
        int n = 32;
        while (n > 0) {
            char c = (char) ('A' + (n - 1) % 26);
            sb.append(c);
            n = (n - 1) / 26;
        }
        sb.reverse();
        String y = sb.toString();
        System.out.print(y);

    }

}
