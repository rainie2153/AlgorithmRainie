package basic3;

import java.util.Stack;

/**
 * Created by yuliu on 7/3/16.
 */

//{2,1,3,3,4} 3*3=9
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                int higher = heights[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                maxArea = Math.max(maxArea, higher * (i - left));
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        int[] array = {1,4,6,8,9,15};
        System.out.print(test.largestRectangleArea(array));
    }
}
