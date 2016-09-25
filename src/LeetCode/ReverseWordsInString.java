package LeetCode;

/**
 * Created by yuliu on 9/14/16.
 *
 * 这道题trick的地方就是有空格 比如input "    a    b  "
 *                            output "b   a"
 *                            Expected"b a"
 *                            so we have to clean up the spaces
 *
 * Input:
            "   one.   +two three?   ~four   !five- "
 Output:
            "-evif! ruof~ ?eerht owt+ .eno"
 Expected:
             "!five- ~four three? +two one."
 *
 */
//I love yahoo ----> yahoo love I
public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        char[] array = s.toCharArray();
        reverseWhole(array, 0, n - 1);
        reverseEach(array, n);
        String res = new String(array);
        return cleanSpaces(array, n);

        //return cleanSpaces(array, n);
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') {//skip spaces
                j++;
            }
            while(j < n && a[j] != ' ') {//keep non spaces
                a[i++] = a[j++];
            }
            while(j < n && a[j] == ' ') {//skip spaces
                j++;
            }
            if (j < n) {//keep only one space
                a[i++] = ' ';
            }
        }
        return new String(a).substring(0, i);
    }


    private void reverseEach(char[] s, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (i < j || i < n && s[i] == ' ') {
                i++;//skip spaces
            }
            while (j < i || j < n && s[j] != ' ') {
                j++;//skip non spaces
            }
            reverseWhole(s, i, j - 1);
        }
    }

    private void reverseWhole(char[] s, int left, int right) {
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String args[]) {
        ReverseWordsInString test = new ReverseWordsInString();
        String s = "I love Yahoo!";//{'i',' ','l','o'}oohay evol i   yahoo love i
        String s1 = "   a.   offer?";
        System.out.print(test.reverseWords(s1));
    }
}
