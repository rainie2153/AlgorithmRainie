package basic3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuliu on 7/3/16.
 */
//https://docs.oracle.com/javase/tutorial/collections/implementations/deque.html
public class KthSmallestWith357AsFactorsDeque {
    public long kthII(int k) {
        long seed = 3 * 5 * 7L;
        Deque<Long> three = new LinkedList<>();
        Deque<Long> five = new LinkedList<>();
        Deque<Long> seven = new LinkedList<>();
        three.add(seed * 3);
        five.add(seed * 5);
        seven.add(seed * 7);
        long result = seed;
        while(k > 1) {
            if (three.peekFirst() < five.peekFirst() && three.peekFirst() < seven.peekFirst()) {
                result = three.pollFirst();
                three.offerLast(result * 3);
                five.offerLast(result * 5);
                seven.offerLast(result * 7);
            } else if (five.peekFirst() < three.peekFirst() && five.peekFirst() < seven.peekFirst()){
                result = five.pollFirst();
                five.offerLast(result * 5);
                seven.offerLast(result * 7);
            } else {
                result = seven.pollFirst();
                seven.offerLast(result * 7);
            }
            k--;
        }
        return result;
    }
    public static void main(String[] args) {
        KthSmallestWith357AsFactorsDeque test = new KthSmallestWith357AsFactorsDeque();
        test.kthII(5);
    }
}
