package Important;

/**
 * Created by yuliu on 8/25/16.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int max = 0;
        while (left <= right) {
            water = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, water);
            if (height[left] < height[right]) {
                left++;
            } else right--;
        }
        return max;
    }
}
