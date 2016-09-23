package basic2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliu on 6/18/16.
 */

//A = {1,1,2,2,3}, B = {1,1,2,5,6}  common number 1,1,2
public class CommonNumber {
    public List<Integer> common (int[] a, int[] b) {
        List<Integer> common = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i++] == b[j++]) {
                common.add(a[i]);
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        } System.out.print(common);
        return common;
    }
    public static void main (String[] args) {
        CommonNumber test = new CommonNumber();
        int[] a = {1,1,2,2,3};
        int[] b = {1,1,2,5,6};
        test.common(a, b);
    }
}
