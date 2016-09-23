package basic3;

/**
 * Created by yuliu on 7/5/16.
 */
//Given an integer array of length L, find the number that occurs more than 0.5*L times
    //The given array is not null or empty
    //It is guaranteed there exists such a majority number
    //A = {1,2,1,2,1}  return 1
public class MajorityNumberI {
    public int majority(int[] array) {
        int candidate = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                count++;
                candidate = array[i];
            } else if (candidate == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        MajorityNumberI test = new MajorityNumberI();
        int[] array = {2,2,2,4,1,5,1,3,3};
        System.out.print(test.majority(array));
    }

}
