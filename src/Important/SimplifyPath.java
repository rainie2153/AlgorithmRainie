package Important;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 8/31/16.
 */
public class SimplifyPath {
    public String simplify(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] split = path.split("\\/");
        Deque<String> deque = new LinkedList<>();
        for (String str : split) {//[a,.,b,..,..,c]
            if (!deque.isEmpty() && str.equals("..")) {
                deque.pollLast();
            } else if (str.equals("..") || str.equals(".") || str.equals("")) {
                continue;
            } else {//如果不出意外都从后面给deque加
                deque.offerLast(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/" + deque.pollFirst());
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        SimplifyPath test = new SimplifyPath();
        String input = new String("/a/./b/../../c/");
        String[] arr = input.split("\\/");
        System.out.print(test.simplify("/a/./b/e/../../c/"));
    }
}
