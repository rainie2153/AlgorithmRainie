package basic2;

/**
 * Created by yuliu on 6/30/16.
 */
public class CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        int[] helper = new int[cuts.length + 2];//need to pad original array at leftmost and rightmost position
        helper[0] = 0;
        for(int i = 0; i < cuts.length; i++) {
            helper[i + 1] = cuts[i];//copy cuts数字到一个新的数组里
        }
        helper[helper.length - 1] = length;
        ////minCost[i][j]: the min cost of cutting the partition(i,j)
        int[][] minCost = new int[helper.length][helper.length];
        for (int i = 1; i < helper.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + 1 == i) {
                    minCost[j][i] = 0; // there is no cutting point between i and j
                } else { // has cutting point between i and j
                    minCost[j][i] = Integer.MAX_VALUE;
                    for (int k = j + 1; k <= i - 1; k++) {
                        minCost[j][i] = Math.min(minCost[j][i], minCost[j][k] + minCost[k][i]);
                    }
                    minCost[j][i] += helper[i] - helper[j];
                }

            }
        }
        return minCost[0][helper.length - 1];
    }

    public static void main(String[] args) {
        CuttingWoodI test = new CuttingWoodI();
        int[] cuts = {4,7};
        test.minCost(cuts, 10);
        System.out.print(test.minCost(cuts,10));
    }
}
