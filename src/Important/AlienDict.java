package Important;

import java.util.HashMap;
import java.util.*;

/**
 * Created by yuliu on 9/17/16.
 */
public class AlienDict {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        Map<Character, Integer> inbound = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();

        //initialize the map
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (!inbound.containsKey(c)) {
                    inbound.put(c, 0);
                }
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
        }

        //build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String prev = words[i];
            String next = words[i + 1];

            int len = Math.min(prev.length(), next.length());
            for (int j = 0; j < len; j++) {
                char pc = prev.charAt(j);
                char nc = next.charAt(j);
                if (pc != nc && !graph.get(pc).contains(nc)) {
                    graph.get(pc).add(nc);
                    inbound.put(nc, inbound.get(nc) + 1);
                    break;
                }
            }
        }

        //bfs
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inbound.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);

            for (Character child : graph.get(curr)) {
                int currInbound = inbound.get(child) - 1;
                if (currInbound == 0) {
                    queue.offer(child);
                }
                inbound.put(child, currInbound);
            }
        }

        for (Map.Entry<Character, Integer> entry : inbound.entrySet()) {
            if (entry.getValue() != 0) {
                return "";
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        AlienDict test = new AlienDict();
        String[] words = {  "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        System.out.print(test.alienOrder(words));
    }
}
