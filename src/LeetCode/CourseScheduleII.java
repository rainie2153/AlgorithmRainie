package LeetCode;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 9/16/16.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] res = new int[numCourses];

        int[] indegrees = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        buildGraph(numCourses, prerequisites, graph, indegrees);

        //BFS
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        int k = numCourses - 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            res[k] = curr;
            k--;

            List<Integer> children = graph.get(curr);

            for (int child : children) {
                indegrees[child]--;
                if (indegrees[child] == 0) {
                    q.offer(child);
                }
            }
        }

        return k < 0 ? res : new int[0];
    }
    public void buildGraph(int numCourses, int[][] prerequisites, List<List<Integer>> graph, int[] indegrees) {
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            indegrees[prerequisite[1]]++;
        }
    }





///第二种用了MAP build graph
    public int[] findOrderUsingMap(int numCourses, int[][] prerequisites) {
        // for each course in the map nextVertex, the corresponding set contains prerequisite courses for this course
        Map<Integer, Set<Integer>> nextVertex = new HashMap<>();
        // preVertex[i] indicates the number of courses that depend on course i
        int[] preVertex = new int[numCourses];

        // set up nextVertex and preVertex
        for (int i = 0; i < prerequisites.length; i++) {
            if (!nextVertex.containsKey(prerequisites[i][0])) {
                nextVertex.put(prerequisites[i][0], new HashSet<>());
            }

            if (nextVertex.get(prerequisites[i][0]).add(prerequisites[i][1])) {
                preVertex[prerequisites[i][1]]++;
            }
        }

        // queue for BFS, which will only hold courses currently upon which no other courses depend
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < preVertex.length; i++) {
            // start from courses upon which no other courses depend. These courses should come last in the order list
            if (preVertex[i] == 0) {
                queue.offerLast(i);
            }
        }

        // array for the result, which will be filled up from the end by index
        int[] res = new int[numCourses];
        int index = res.length - 1;

        while (!queue.isEmpty()) {
            int key = queue.pollFirst(); // this is a course that no other courses will depend upon
            res[index--] = key;          // so we put it at the end of the order list

            // since we are done with course "key", for any other course that course "key" is dependent on, we can decrease
            // the corrresponding preVertex by one and check if it is qualified to be added to the queue.
            if (nextVertex.containsKey(key)) {
                for (int i : nextVertex.get(key)) {
                    if (--preVertex[i] == 0) {
                        queue.offerLast(i);
                    }
                }
            }

            --numCourses; // we are done with course "key", so reduce the remaining number of courses by 1
        }

        // if the remaining number of courses is not zero, then we cannot complete all the courses; otherwise return the result
        return numCourses == 0 ? res : new int[0];
    }



    public static void main(String args[]) {
        CourseScheduleII test = new CourseScheduleII();
        int[][] input = {{0,1},{0,2},{1,2}};
        System.out.print(test.findOrder(3, input));
    }

}
