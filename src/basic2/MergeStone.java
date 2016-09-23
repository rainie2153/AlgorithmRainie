package basic2;

/**
 * Created by yuliu on 6/30/16.
 */
//We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers
    //In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of
    //the two piles. We merge the piles of stons until we have only one pile left. Determine the min total cost
    //{4,3,3,4} the min cost is 28
    //merge first 4 and first 3 cost is 7
    //merge second 3 and second 4 cost is 7
    //merge two 7s, cost is 14
    //total cost = 7 + 7 + 14 = 28

public class MergeStone {
    public int minCost(int[] stones) {
        int len = stones.length;
        int[][] cost = new int[len][len];
        int[][] subSum = new int[len][len];
        for (int i = 0; i < len; i++) {

        }
        return 0;
    }


}
