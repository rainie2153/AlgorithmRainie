package basic2;

/**
 * Created by yuliu on 6/27/16.
 */
//Given an array of integers without any duplicates, shuffle the array such that all permutaitons are
    //equally likely to be generated
public class PerfectShuffle {
    public void shuffle(int[] array) {
        if (array.length <= 1) {
            return;
        }
        // from right to left, for index i-1 , randomly pick one of the first i elements
        for (int i = array.length; i >= 1; i--) {
            int idx = (int)(Math.random()*i);
            swap(array, i - 1, idx);
        }
    }
    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        PerfectShuffle test = new PerfectShuffle();
        int[] array = {3, 2, 1};
        test.shuffle(array);
    }

}
