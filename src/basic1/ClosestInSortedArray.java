package basic1;

/**
 * Created by yuliu on 3/11/16.
 */
public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        if(array == null || array.length == 0 ) return -1;
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid;
            } else return mid;
        }
        if (Math.abs(array[left] - target) < Math.abs(array[right] - target) ) {
            return left;
        } else return right;

    }


    public static void main(String[] args) {
        ClosestInSortedArray fs = new ClosestInSortedArray();
        int[] array = {1,3,3,5,8,11,13};
        int target = 6;
        System.out.print(fs.closest(array, target));
    }
}
