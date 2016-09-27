package mianjing;

import java.util.ArrayList;

/**
 * Created by yuliu on 9/27/16.
 */
public class AllPossibleProductOfPrimeNumbers {
    public ArrayList<Integer> primeProducts(int[] primes) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < primes.length; i++) {
            int len = result.size();
            result.add(primes[i]);
            for (int j = 0; j < len; j++) {
                result.add(result.get(j) * primes[i]);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        AllPossibleProductOfPrimeNumbers test = new AllPossibleProductOfPrimeNumbers();
        int[] input = {3,5,11};
        System.out.print(test.primeProducts(input));
    }
}
