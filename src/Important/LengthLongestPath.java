package Important;

import java.util.Stack;

/**
 * Created by yuliu on 8/22/16.
 */
//"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
    /*
    dir
\
	subdir1
\
	subdir2
\
		file.ext
4
     */
//the depth of the directory/file is calculated by counting how many"\t"s are there
    //The time complexity if O(n) because each substring in the input string only goes into the stack once and pop out from the stack once
public class LengthLongestPath {
    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int res = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            int level = countLevel(s);
            while(stack.size() > level) {
                curLen -= stack.pop();
            }
            int len = s.replace("\t", "").length() + 1;
            curLen += len;
            if(s.contains(".")) {
                res = curLen - 1 > res ? curLen - 1 : res;
            }

            stack.add(len);
         }
        return res;
    }
    private int countLevel(String s) {
        String cur = s.replace("\t", "");
        return s.length() - cur.length();
    }
    public static void main(String args[]) {
        LengthLongestPath test = new LengthLongestPath();
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsuverylonglonglonglonglongbdir1\n\t\t\taaaaaaaaaaaaaaaaaaaaasth.png\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        //char[] chararr = input.toCharArray();
        int lastindex = input.lastIndexOf(" ");
        String[] arr = input.split("\n");
        for (String s : arr) {
            System.out.println("\\");
            System.out.println(s);
        }
        String cur = input.replace("\t", "");
        int diff = input.length() - cur.length();
        System.out.println(lastindex);
        System.out.print(test.lengthLongestPath(input));
    }

}
