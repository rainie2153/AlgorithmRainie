package basic1;

/**
 * Created by yuliu on 3/11/16.
 */
public class fisrtOccur {
    public int firstoccur(int[] array, int target) {
        if(array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;

        while (left < right -1) {
            int mid = left + (right - left)/2;
            if (array[mid] == target) right = mid;
            else if (array[mid] < target) left = mid + 1 ;else right = mid - 1;
        }
        if (array[left] == target) return left;
        if (array[right] == target) return right;
        return -1;

    }

    public static void main(String[] args) {
        fisrtOccur fs = new fisrtOccur();
        int[] array = {1,2,2,2,3,3,3,3,3};
        int target = 3;
        System.out.print(fs.firstoccur(array, target));
    }
}
