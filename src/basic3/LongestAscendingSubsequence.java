package basic3;

/**
 * Created by yuliu on 7/5/16.
 */
public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        //the smallest ending value of all the ascending subsequence with length i
        int[] length = new int[array.length + 1];
        int result = 1;
        length[1] = array[0];
        for (int i = 1; i < array.length; i++) {
            int index = find(length, 1, result, array[i]);//传进来的target是array当前的元素
            if (index == result) {//ascending
                length[++result] = array[i];
            } else {//后面小
                length[index + 1] = array[i];
            }
        }
        return result;
        }

    private int find(int[] length, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (length[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return right;
    }

    public static void main(String[] args) {
        LongestAscendingSubsequence test = new LongestAscendingSubsequence();
        int[] array = {3, 4, 5, 3, 4, 6};
        System.out.print(test.longest(array));
    }
}


