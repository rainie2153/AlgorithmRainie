package Important;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by yuliu on 9/4/16.
 * Given two words and a dic, find all shortest transformation sequences from begin to end such that
 * 1.Only can be change at a time
 * 2.Each intermediate word must exist in word list
 *
 * Using BFS to build the whole graph, and use map to store the shortest distance from begain word
 * to here.

 After the map is built, using DFS starting from the end word, moves towards the start. For the DFS, I will need to build a path when doing BFS.
 The first step BFS is quite important
 I summarized three tricks
 1.use a MAP to store min ladder of each word or use a SET to store the words visited in current ladder, when the current ladder
 was completed, delete the visited words from unvisited.
 2.
 */
public class WordLadderII {
        public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
            // method would be similar, except that, we need to store the path
            // in addition, if we get the result, we didn't stop until we finish
            // all the path of the same length
            // visited map the string to the list of its ancestor
            HashMap<String, HashSet<String>> visited = new HashMap<String, HashSet<String>>();
            HashMap<String, Integer> level = new HashMap<String, Integer>();
            LinkedList<String> queue = new LinkedList<String>();
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            if (start==null || end==null || start.length()!=end.length()) {
                return result;
            }
            // we also need to store the path for the start
            HashSet<String> path = new HashSet<String>();
            // we record the minimal length we get
            int min_length = Integer.MAX_VALUE;
            visited.put(start, path);
            level.put(start, 1);
            queue.add(start);

            while(!queue.isEmpty()) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                for (int i = 0; i < s.length(); i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <='z'; c++) {
                        chars[i] = c;
                        String s2 = new String(chars);
                        // avoid circle
                        // check whether it is in the dictionary
                        // we only add the string which is nearer to the start
                        if (dict.contains(s2) && (!level.containsKey(s2) || (level.containsKey(s2) && level.get(s2) > level.get(s)))) {
                            // we update the ancestor of the string
                            if (visited.containsKey(s2)) {
                                visited.get(s2).add(s);
                            }
                            else {
                                // we haven't seen this node before
                                // thus we add it to the queue and also its ancestor
                                path = new HashSet<String>();
                                path.add(s);
                                visited.put(s2, path);
                                level.put(s2, level.get(s) + 1);
                                queue.add(s2);
                            }
                        }
                        if (s2.equals(end)) {
                            // we found it
                            // we will use back trace to found its path to start
                            if (level.get(s) < min_length)
                            {
                                // it is shortest path
                                ArrayList<String> entry = new ArrayList<String>();
                                entry.add(end);
                                result.addAll(back_trace(s, visited, entry));
                                min_length=level.get(s)+1;
                            }
                            else
                            {
                                // ok, all the remaining path should be longer
                                break;
                            }
                        }
                    }
                    chars[i] = old;
                }
            }
            return result;
        }

        private ArrayList<ArrayList<String>> back_trace(String end, HashMap<String, HashSet<String>> visited, ArrayList<String> path) {
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            ArrayList<String> entry = new ArrayList<String>(path);
            entry.add(0, end);
            if (visited.get(end).size() < 1) {
                result.add(entry);
                return result;
            }
            for (String str : visited.get(end)) {
                result.addAll(back_trace(str, visited, entry));
            }
            return result;
        }

    public static void main(String args[]) {
        WordLadderII test = new WordLadderII();
        HashSet<String> dic = new HashSet<>();
        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
        System.out.print(test.findLadders("hit", "cog", dic));
    }
}


