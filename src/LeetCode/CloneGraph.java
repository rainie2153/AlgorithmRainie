package LeetCode;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 9/5/16.
 * Given an undirected graph. Each node in the graph contains a laber and a list of its neighbors
 */
public class CloneGraph {
    static class UndirectedGraphNode{
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            this.label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    //BFS and then clone edges
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        //first clone nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        while(!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            for (UndirectedGraphNode nei : temp.neighbors) {
                if (!map.containsKey(nei)) {
                    UndirectedGraphNode copynei = new UndirectedGraphNode(nei.label);
                    map.put(nei, copynei);
                    q.offer(nei);
                }
            }
        }
        //copy edges
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()) {
            UndirectedGraphNode cur = entry.getKey();
            UndirectedGraphNode copynei = entry.getValue();
            for (UndirectedGraphNode nei : cur.neighbors) {
                copynei.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
    public static void main(String args[]) {
        CloneGraph test = new CloneGraph();
        UndirectedGraphNode zero = new UndirectedGraphNode(0);
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        UndirectedGraphNode three = new UndirectedGraphNode(3);

        //zero.neighbors = new ArrayList<>();

        zero.neighbors.add(one);
        zero.neighbors.add(two);
        zero.neighbors.add(three);
       // two.neighbors = new ArrayList<>();
        two.neighbors.add(zero);
        two.neighbors.add(three);
        three.neighbors.add(zero);
        three.neighbors.add(two);

        test.cloneGraph(zero);
    }
}
