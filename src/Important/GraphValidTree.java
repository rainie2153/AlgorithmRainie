package Important;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuliu on 7/29/16.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        buildGraph(n, edges, graph);

        return dfs(n, graph); //method1: BFS
    }

    public void buildGraph(int n, int[][] edges, List<List<Integer>> graph) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public boolean bfs(int n, List<List<Integer>> graph) {
        if (n == 0) return true;
        Queue<Integer> q = new LinkedList<Integer>();
        int[] visited = new int[n];

        q.offer(0);
        visited[0] = 1;// 1 means the node is in the queue
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int child : graph.get(curr)) {
                if (visited[child] == 1) return false; //the node is in the queue
                else if (visited[child] == 0) {
                    q.offer(child);
                    visited[child] = 1;
                }
            }
            visited[curr] = 2;
        }

        for (int i : visited) {
            if (i != 2) return false;
        }
        return true;
    }

    public boolean dfs(int n, List<List<Integer>> graph) {
        int[] visited = new int[n]; //0 represents not visited, 1 represents visiting, 2 represents visited
        if (!dfs(0, 0, graph, visited)) return false;

        for (int i : visited) {
            if (i != 2) return false;
        }
        return true;
    }

    public boolean dfs(int i, int pre, List<List<Integer>> graph, int[] visited) {
        if (visited[i] != 0) return false;
        visited[i] = 1;

        for (int child : graph.get(i)) {
            if (child != pre) {
                if (!dfs(child, i, graph, visited)) {
                    return false;
                }
            }
        }

        visited[i] = 2;
        return true;
    }
    public static void main(String args[]) {
        GraphValidTree test = new GraphValidTree();
        int[][] input = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] cycle = {{2,3},{1,4},{1,3},{0,1}};
        System.out.print(test.validTree(5,input));
    }
}
