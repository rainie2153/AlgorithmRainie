package mianjing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuliu on 9/24/16.
 * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number
 * Input: arr[] = {1,4,20,3,10,5}  sum = 33
 * output: targetsum found between index 2 to 4(including). 因为20+3+10 = 33
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 Ouptut: Sum found between indexes 1 and 4
 Input: arr[] = {1, 4}, sum = 0
 Output: No subarray found

 解：consider all subarrays one by one and check the sum of every subarray. Run two loops, pick a starting
 point i and inner loop try all subarray starting from i
 Method1. O(n^2) O(1)
 Method2. HashMap O(n) O(n)
 */
public class FindSubArrWithGivenSum {
    public int subArrSum(int[] arr, int target) {
        int curSum;
        for (int i = 0; i < arr.length; i++) {
            curSum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (curSum == target) {
                    System.out.println(i);
                    System.out.println(j - 1);
                    return j - i;
                } else if (curSum > target) {
                    break;
                } else {
                    curSum += arr[j];
                }
            }
        }
        return 0;
    }

/**
 * The idea is to iterate through the arr and for each element arr[i] caculate sum of elements from 0 to
 * i this can be done as sum += arr[i], if target - curSum has been seen before, then there is
 */
    public int findSubArrSumHash(int[] arr, int target) {
        int[] sum = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();//key存目前的sum,value存对应截止到哪个index
//        //先build map
//        for (int i = 0; i < arr.length; i++) {
//            sum[i] += arr[i];
//            if (!map.containsKey(sum[i])) {
//                map.put(sum[i],i);
//            }
//        }
        sum[0] = arr[0];
        map.put(sum[0], 0);
        for (int j = 1; j < arr.length; j++) {
            sum[j] = sum[j - 1] + arr[j];
            map.put(sum[j], j);
            if (map.containsKey(sum[j] - target)) {
                int i = map.get(sum[j] - target) + 1;
                System.out.println(i);
                System.out.println(j);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindSubArrWithGivenSum test = new FindSubArrWithGivenSum();
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        test.findSubArrSumHash(arr, sum);
    }

}
