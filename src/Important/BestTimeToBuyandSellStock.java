package Important;

/**
 * Created by yuliu on 9/4/16.
 * 变种3
 */
public class BestTimeToBuyandSellStock {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if(size == 0 || size == 1) {
            return 0;
        }

        int profit1[] = new int[size];
        int profit2[] = new int[size];
        int local_min = prices[0];
        int local_max = prices[size - 1];
        int j = size - 2;
        int result = 0;
        profit1[0] = 0;
        profit2[size - 1] = 0;
        for(int i = 1; i < size + 1 && j >= 0; i++, j--) {
            local_min = Math.min(local_min, prices[i]);
            profit1[i] = Math.max(profit1[i - 1], prices[i] - local_min);

            profit2[j] = Math.max(profit2[j + 1], local_max - prices[j]);
            local_max = Math.max(local_max, prices[j]);
        }
        for(int i = 1; i < size; i++) {
            result = Math.max(result, profit1[i] + profit2[i]);
        }
        return result;
    }

    public static void main(String args[]) {
        BestTimeToBuyandSellStock test = new BestTimeToBuyandSellStock();
        int[] prices = {2,4,8,1,5};
        test.maxProfit(prices);
    }
}
