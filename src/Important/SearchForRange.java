package Important;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 8/28/16.
 */
public class SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) {
                left = mid;
                right = mid;
                while (left >= 0 && target == nums[left]) {
                    left--;
                }
                while (right < nums.length && target == nums[right]) {
                    right++;
                }

                return new int[]{left + 1, right - 1};
            } else if (target < nums[mid]) {
                right = mid - 1;
                continue;
            } else {
                left = mid + 1;
                continue;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String args[]) {
        SearchForRange test = new SearchForRange();
        int[] input = {5, 7, 7, 8, 8, 10};
        System.out.print(test.searchRange(input, 8));
    }
}
