package mianjing;

/**
 * Created by yuliu on 9/27/16.
 * 给你一个array，返回array里面最大数字的index，但是必须是最大数字里面随机的一个index。
 * 比如  [2,1,2,1,5,4,5,5]必须返回4，6，7中的随机的一个数字。
 */
public class IndexOfLargestNumber {
    public int indexOfLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        int max_count = 1;
        int max_idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                max_count = 1;
                max_idx = i;
            } else if (arr[i] == max) {
                ++max_count;
                if (Math.random() < 1.0 / max_count) {
                    max_idx = i;//每次从左往右扫，然后遇到最大值就取个随机数，看看是不是用新的index代替现在的那个index
                }
            }
        }
        return max_idx;
    }
}
