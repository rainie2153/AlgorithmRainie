package Important;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yuliu on 8/10/16.
 */
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] array = new int[cols];
        int maxRec = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[j] = matrix[i][j] == 0 ? 0 : 1 + array[j];
            }
            maxRec = Math.max(maxRec, largestRectangleArea(array));
        }
        return maxRec;
    }

    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Deque<Integer> s = new LinkedList<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);//保持stack是生序排列高度对应的index
            }else{
                int top = s.pop();//栈顶每次遇到矮子就pop出来计算下最大直方图面积
                maxArea = Math.max(maxArea, height[top] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximumRectangle test = new MaximumRectangle();
        char[][] input = {  {1, 0, 1, 0, 0},
                            {1, 0, 1, 1, 1},
                            {1, 1, 1, 1, 1},
                            {1, 0, 0, 1, 0}};
        System.out.print(test.maximalRectangle(input));
        //int[] height = {1,19,20,18,2};
        //System.out.print(test.largestRectangleArea(height));

    }
}
