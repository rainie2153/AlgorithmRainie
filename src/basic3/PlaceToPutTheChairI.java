package basic3;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuliu on 7/3/16.
 */
//Given a gym with k pieces of equipment and some obstacles. We bought a chair and wanted to put this chair into the gym
    //such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal.
    //The gym is represented by a char matrix. 'E' denotes a cell with equipment. 'O' denotes a cell with an obstacle
    //'C' denote a cell without any equipment or obstacle. You can only move to neighboring cells (left, right, up, down)
    //if the neighboring cell is not an obstacle. The cost of moving from one cell to its neighbor is 1. You cannot put
    //the chair on a cell with equipment or obstacle...
    //Assumption: There is at least one equipment. The given gym is represented by a char matrix of size M * N
    //{ {'E', 'O', 'C'},
    //   {'C', 'E', 'C'}
    //  {'C', 'C', 'C'}
//      }
    //We should put the chair at (1,0) so that the sum of cost from the chair to the two equipment is 1+1=2 which is min
public class PlaceToPutTheChairI {
    private static final char EQUIP = 'E';
    private static final char OB = 'O';

    public List<Integer> putChair(char[][] gym) {
        int M = gym.length;
        int N = gym[0].length;

        int[][] cost = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if (EQUIP == gym[i][j]) {
                    //use BFS to calculate the shortest path cost from each of the equipments to all the other reachable cells
                    //and add the cost to each corresponding cell
                    if (!addCost(cost, gym, i, j)) {
                        return null;
                    }
                }
            }
        }
        //find the cell with smallest sum of shortest path cost to all the 'E' cell
        List<Integer> result = null;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (EQUIP != gym[i][j] && OB != gym[i][j]) {
                    if (result == null) {
                        result = Arrays.asList(i, j);
                    } else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
                        result.set(0, i);
                        result.set(1, j);
                    }
                }
            }
        }
        return result;
    }

    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
        //use a boolean matrix to make sure each cell will be visited no more than once
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int pathCost = 1;
        Queue<Pair> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new Pair(i, j));


        return true;
    }

}
