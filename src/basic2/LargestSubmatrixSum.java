package basic2;

/**
 * Created by yuliu on 6/27/16.
 */
public class LargestSubmatrixSum {
    public int largest(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;//输入是个2维矩阵,flatten to 1维
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] cur = new int[M];
            for (int j = i; j < N; j++) {
                //for each row i, add row one by one
                add(cur, matrix[j]);
                result = Math.max(result, max(cur));
            }
        }
        System.out.print(result);
        return result;
    }
    private void add(int[] cur, int[] add) {
        for (int i = 0; i < cur.length; i++) {
            cur[i] += add[i];//跟cur这个数字里面加上撸过一遍的元素进去
        }
    }

    private int max(int[] cur) {
        int result = cur[0];
        int tmp = cur[0];
        for (int i = 1; i < cur.length; i++) {
            tmp = Math.max(tmp + cur[i], cur[i]);//比较自己跟自己前面的值
            result = Math.max(result, tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestSubmatrixSum test = new LargestSubmatrixSum();
        int[][] matrix = {{1, -3, 100},{2, -1, 1},{-100, 200, 3}, {0, 1, 2}};
        test.largest(matrix);
    }
}
