package Important;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuliu on 8/10/16.
 */
public class MinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;

        if (n == 1) {
            res.add(0);
            return res;
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] outdegree = new int[n];//

        buildGraph(n, edges, graph, outdegree);

        //bfs from out vertex
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 1) {
                q.offer(i);
                outdegree[i]--;
            }
        }

        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                res.add(curr);
                List<Integer> children = graph.get(curr);

                for (int child : children) {
                    outdegree[child]--;

                    if (outdegree[child] == 1) {
                        q.offer(child);
                    }
                }

            }
        }

        return res;



    }

    public void buildGraph(int n, int[][] edges, List<List<Integer>> graph, int[] outdegree) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            outdegree[edge[0]]++;
            outdegree[edge[1]]++;
        }
    }
    public static void main(String args[]) {
        MinHeightTree test = new MinHeightTree();
        int edge[][] = {{1,0},{1,2}, {1,3}};
        System.out.print(test.findMinHeightTrees(4,edge));
    }
}
