package Important;

import java.util.HashMap;

/**
 * Created by yuliu on 8/24/16.
 */
public class TwoSumleetcode {
    public int[] indexofTwoSumMethod1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[] {map.get(tmp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }

    public int[] indexofTwoSumMethod2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int j = binarySearch(nums, target - nums[i], i + 1);
            if (j != -1) {
                int[] res = new int[]{i, j};
                return res;
            }
        }
        return new int[]{-1,-1};
    }

    private int binarySearch(int[] nums, int target, int left) {
        int l = left;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int[] twoSumSortedMethod3(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                int[] res = new int[] {i, j};
                return res;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String args[]) {
        TwoSumleetcode test = new TwoSumleetcode();
        int[] nums = {0,1,2,3};
        System.out.println(test.twoSumSortedMethod3(nums, 3));
        boolean[][] matrix = new boolean[3][3];
        System.out.print(matrix[0][0]);
        System.out.print(matrix[0][1]);
        System.out.print(matrix[0][2]);
        System.out.print(matrix[1][0]);


    }
}
