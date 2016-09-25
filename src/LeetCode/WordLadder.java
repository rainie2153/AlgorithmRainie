package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by yuliu on 9/4/16.
 * Given two words begin and end , and a dict of word list.
 * Find the len of shortest transformation sequence from begin to end
 * 1.Only one letter can be changed at a time
 * 2.Each intermediate word must exist in word list
 *
 * start:"hit"
 * end: "cog"
 * Since only one letter can be changed at a time, if we start from hit, we can only change to those words which have only one
 * different letter from it. like hot, put in graph-theoretic terms,hot is a neighbor of hit
 *
 * The idea is simply to begin from start, then we visit its neighbors, then non-visited neighbors of its neighbors.
 * BFS structure
 * To simplify the problem, we insert end into dict. Once we meet end during BFS, we know we have found the answer.
 * We maintain a variable dist for current distance of the transformation and update it by dist++ after we finish a round of BFS search
 * (Note that it should fit the definition of the distance in the problem statement)
 * Also, to avoid visiting a word for more than once, we erase it from dict once it is visited.
 *
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        //Use queue to help BFS
        Queue<String> q = new LinkedList<>();
        q.add(start);
        q.add(null);

        //Mark visited word
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int level = 1;

        while (!q.isEmpty()) {
            String str = q.poll();
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {//str开始是hit
                    char[] chars = str.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;//ait,bit,cit,dit.....zit

                        String word = new String(chars);//转成string ait

                        //Found the end word
                        if (word.equals(end)) {
                            return level + 1;
                        }

                        //put it to the queue
                        if (dict.contains(word) && !visited.contains(word)) {
                            q.offer(word);
                            visited.add(word);
                        }

                    }
                }
            } else {
                level++;
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
        return 0;//means invalid distance
    }

    public static void main(String args[]) {
        WordLadder test = new WordLadder();
        Set<String> dic = new HashSet<>();
        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("cit");
        dic.add("cot");
        System.out.print(test.ladderLength("hit", "cog", dic));
    }
}
