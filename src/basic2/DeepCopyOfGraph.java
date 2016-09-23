package basic2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuliu on 6/30/16.
 */
//Make a deep copy of an undirected graph, there could be cycles in the original graph
public class DeepCopyOfGraph {
    class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }
    public List<GraphNode> copy(List<GraphNode> graph) {
        if (graph == null) {
            return null;
        }
        HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
        for(GraphNode node : graph) {
            if(!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
                DFS(node, map);
            }
        }
        return new ArrayList<GraphNode>(map.values());
    }
    private void DFS(GraphNode seed, HashMap<GraphNode, GraphNode> map) {
        GraphNode copy = map.get(seed);
        for (GraphNode nei : seed.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new GraphNode(nei.key));
                DFS(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }
    }
}
