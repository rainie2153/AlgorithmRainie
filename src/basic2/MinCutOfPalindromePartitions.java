package basic2;

/**
 * Created by yuliu on 6/29/16.
 */
//Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is
    //a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string
public class MinCutOfPalindromePartitions {
    public int minCuts(String input) {
        char[] array = input.toCharArray();//首先把一个string变成个charArray//abab
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        //isP[i][j]means substring(i - 1, j - 1) isP
        boolean[][] isP = new boolean[len + 1][len + 1];
        int[] minCuts = new int[len + 1];
        for (int end = 1; end <= len; end++) {
            minCuts[end] = end;
            for(int start = end; start >= 1; start--) {
                if (array[start - 1] == array[end - 1]) {
                    //if(--- end - start < 2 || isP[start + 1][end - 1]--) isP = ture;
                    isP[start][end] = end - start < 2 || isP[start + 1][end - 1];//ababa
                }
                //use isP[start][end] to calculate minCuts[end]
                if(isP[start][end]) {
                    minCuts[end] = Math.min(minCuts[end], 1 + minCuts[start - 1]);
                }
            }
        }

        return minCuts[len] - 1;

    }
    public static void main(String[] args) {
        MinCutOfPalindromePartitions test = new MinCutOfPalindromePartitions();
        String input = "ababe";
        test.minCuts(input);
    }
}
