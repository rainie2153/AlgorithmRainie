package LeetCode;

/**
 * Created by yuliu on 9/5/16.
 * Given a string s, partition s such that every substring of the partition is a palindrome
 * Return the minimum cuts needed for a palindrome partioning of s
 *
 *
 * I'd like to help explain this great algorithm. :-O

 This divide-and-conquer algorithm utilize the symmetry of palindromes, so there is no need to cache the result of whether s[i:j) is a palindrome.

 Say that it started at s[i] = 'b', and s[i-1,i+1] is a palindrome "aba":

 .......aba...
 |<-X->| ^
 |<---Y-->|
 And we know the least cuts for s[0,i-1) is X, then the least cuts for s[0,i+1] Y is not greater than X+1. Last, we need to find out all the palindromes in s[0,i+1] so as to minimize the number of cuts.
 */
public class PalindromePartitionII {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int n = s.length();
        int[] cut = new int[n + 1];//number of cuts for the first k characters
        for (int i = 0; i <= n; i++) {
            cut[i] = i - 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) {//odd length
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);
            }
            for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); j++) {//even
                cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
            }
        }
        return cut[n];
    }
    public static void main(String args[]) {
        PalindromePartitionII test = new PalindromePartitionII();
        System.out.print(test.minCut("aab"));
    }
}
