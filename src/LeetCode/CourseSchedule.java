package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuliu on 7/26/16.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);

        buildGraph(graph, numCourses, prerequisites);

        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> visiting = new HashSet<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, visiting)) return false;
        }
        return true;

    }

    public void buildGraph(List<List<Integer>> graph, int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : prerequisites) {
           // System.out.print(edge);
            //System.out.print(graph.get(edge[1]));
            //System.out.print(graph.get(edge[2]));


            System.out.print("---");

            graph.get(edge[0]).add(edge[1]);
            //System.out.print(graph.get(edge[0]));
            //System.out.print(graph.get(edge[1]));

        }
    }

    public boolean dfs(int i, List<List<Integer>> graph, Set<Integer> visited, Set<Integer> visiting) {
        if (visiting.contains(i)) {
            return false;
        }
        if (visited.contains(i)) {
            return true;
        }

        visiting.add(i);
        List<Integer> neighbours = graph.get(i);
        for (Integer neighbour : neighbours) {
            if (!dfs(neighbour, graph, visited, visiting)) return false;
        }

        visited.add(i);
        visiting.remove(i);

        return true;

    }
    public static void main(String args[]) {
        CourseSchedule test = new CourseSchedule();
        int[][] input = {{0,1},{1,2}};
        System.out.print(test.canFinish(3, input));
    }

}
