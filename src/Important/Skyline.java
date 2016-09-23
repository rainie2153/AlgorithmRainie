package Important;

import java.util.*;

/**
 * Created by yuliu on 9/16/16.
 * Given the locations and height of all buildings as shown on a cityscape photo
 *
 */
public class Skyline {
    static class BuildingNode{
        int location;
        int height;
        boolean isStart;
        public BuildingNode(int location, int height, boolean isStart) {
            this.location = location;
            this.height = height;
            this.isStart = isStart;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        List<BuildingNode> buildingNodes = new ArrayList<>();
        for (int[] building : buildings) {
            buildingNodes.add(new BuildingNode(building[0], building[2], true));
            buildingNodes.add(new BuildingNode(building[1], building[2], false));
        }
        Collections.sort(buildingNodes, new Comparator<BuildingNode>() {
            @Override
            public int compare(BuildingNode o1, BuildingNode o2) {
                if (o1.location != o2.location) {
                    return o1.location - o2.location;//按照从小到大排序
                } else if (o1.isStart && o2.isStart) {
                    return o2.height - o1.height;//从大到小
                } else if (!o1.isStart && !o2.isStart) {
                    return o1.height - o2.height;//先小
                } else if (o1.isStart && !o2.isStart) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        //Queue<Integer> queue = new PriorityQueue<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();//key记录高度val记录这个高度出现的次数
        treeMap.put(0, 1);
        int prevMaxHeight = 0;
        for (BuildingNode buildingNode : buildingNodes) {
            int h = buildingNode.height;
            if (buildingNode.isStart) {
                if (treeMap.containsKey(h)) {
                    treeMap.put(h, treeMap.get(h) + 1);
                } else {
                    treeMap.put(h, 1);
                }
            } else {//end
                if (treeMap.get(h) == 1) {
                    treeMap.remove(h);
                } else {
                    treeMap.put(h, treeMap.get(h) - 1);
                }
            }
            int curMaxHeight = treeMap.lastKey();
            if (curMaxHeight != prevMaxHeight) {
                res.add(new int[]{buildingNode.location, curMaxHeight});
                prevMaxHeight = curMaxHeight;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Skyline test = new Skyline();
        int[][] b1 = {{1,4,1},{4,6,1},{8,10,1}};
        int[][] buildings = {{1, 4, 8}, {2, 3, 1}, {4, 10, 1}};
        test.getSkyline(b1);
    }
}
