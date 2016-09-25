package LeetCode;

import java.util.Arrays;

/**
 * Created by yuliu on 8/9/16.
 */
public class reverseWord {
    public String reverseWords(char[] array) {
        //1.reverse the whole char array
        reverse(array, 0, array.length - 1);
        int start = 0;
        //2.reverse each of words
        for (int i = 0; i < array.length; i++) {
            // the start index of a word
            if (array[i] != ' ' && (i == 0|| array[i - 1] == ' ')) {
                start = i;
            }
            //the end index of a word
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        return Arrays.toString(array);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String args[]) {
        reverseWord test = new reverseWord();
        String s = "I love Yahoo!";//{'i',' ','l','o'}oohay evol i   yahoo love i
        char[] array = s.toCharArray();
        System.out.print(test.reverseWords(array));
    }
}
