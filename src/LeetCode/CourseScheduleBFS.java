package LeetCode;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 9/23/16.
 */
public class CourseScheduleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) {
            return true;
        }
        if (prerequisites == null || prerequisites.length <= 1) {
            return true;
        }

        //build graph
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> set = new HashSet<Integer>();
            graph.put(i, set);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        Queue<Integer> q = new LinkedList<Integer>();
        int coursesLeft = numCourses;

        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 0) {
                q.offer(entry.getKey());
                coursesLeft--;
            }
        }

        while (!q.isEmpty()) {
            int key = q.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                if (entry.getValue().contains(new Integer(key))) {
                    entry.getValue().remove(new Integer(key));
                    if (entry.getValue().size() == 0) {
                        q.offer(entry.getKey());
                        coursesLeft--;
                    }
                }
            }
        }
        return coursesLeft == 0;
    }
    public static void main(String args[]) {
        CourseScheduleBFS test = new CourseScheduleBFS();
        int[][] input = {{0,1},{0,2},{2,0}};
        System.out.print(test.canFinish(3, input));
    }

}
