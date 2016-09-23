package Important;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by yuliu on 8/22/16.
 */
public class FirstUniqueCharinString {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for (char ele : arr) {
            if(!map.containsKey(ele)) {
                map.put(ele, 1);
                queue.offer(s.indexOf(ele));
            } else map.put(ele, map.get(ele) + 1);
        }
        int index = -1;
        while(!queue.isEmpty()) {
            index = queue.poll();
            if (map.get(arr[index]) == 1) {
                return index;
            }
        }
        return index;

    }

    public static void main(String[] args) {
        FirstUniqueCharinString test = new FirstUniqueCharinString();
        String s = "cc";
        System.out.print(test.firstUniqChar(s));

    }
}
