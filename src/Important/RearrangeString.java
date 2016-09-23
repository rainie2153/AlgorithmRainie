package Important; /**
 * Created by yuliu on 9/23/16.
 */
import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 8/1/16.
 */
public class RearrangeString {
    public String rearrangeString(String str, int k) {
        if (k == 0) {
            return str;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] ss = str.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (map.containsKey(ss[i])) {
                map.put(ss[i], map.get(ss[i]) + 1);
            } else {
                map.put(ss[i], 1);
            }
        }
        Queue<Character> queue = new PriorityQueue<Character>(11,
                new Comparator<Character>() {
                    @Override
                    public int compare(Character c1, Character c2) {
                        int num1 = map.get(c1);
                        int num2 = map.get(c2);
                        if (num2 != num1) {
                            return num2 - num1;//number不同number大的在前面
                        } else {
                            return c1 - c2;//number相同字符数小的在前面
                        }
                    }
                });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
        }

        StringBuilder rs = new StringBuilder("");
        while (!queue.isEmpty()) {
            List<Character> tmp = new ArrayList<Character>();
            int i = 0;
            for (; i < k; i++) {
                Character c1 = queue.poll();
                rs.append(c1);
                tmp.add(c1);
                if (queue.isEmpty()) {
                    break;
                }
            }
            for (char c : tmp) {
                if (map.get(c) > 1) {
                    if (i < k - 1) {
                        return "";
                    }
                    map.put(c, map.get(c) - 1);
                    queue.offer(c);
                }
            }
        }

        return rs.toString();
    }

    public static void main(String args[]) {
        RearrangeString test = new RearrangeString();
        test.rearrangeString("aaadbbcc", 2);
    }
}


