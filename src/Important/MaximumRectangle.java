package Important;

import java.util.Stack;

/**
 * Created by yuliu on 8/10/16.
 */
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[] array = new int[cols];
        int maxRec = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int check = matrix[i][j];
                array[j] = matrix[i][j] == 0 ? 0 : 1 + array[j];
            }
            maxRec = Math.max(maxRec, largestRectangleArea(array));
        }
        return maxRec;
    }


    private int largestRectangleArea(int[] heights) {
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
        MaximumRectangle test = new MaximumRectangle();
        char[][] input = {  {1, 0, 1, 0, 0},
                            {1, 1, 1, 1, 1},
                            {0, 1, 1, 1, 1},
                            {1, 0, 1, 1, 1}};
        System.out.print(test.maximalRectangle(input));

    }
}
