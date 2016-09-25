package LeetCode;

import java.util.*;
import java.util.HashMap;

/**
 * Created by yuliu on 8/2/16.
 */
public class TopKFreq {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0) return new ArrayList<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i]) + 1);
                }else map.put(nums[i], 1);
            }

        List<Integer> res = new ArrayList();
        // first is frequency,  second is number
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(11, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue() < (e2.getValue()) ? -1 : 1;
            }
        }
        );
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        int size = minHeap.size();
        for (int i = 0; i < size; i++) {
            res.add(0, minHeap.poll().getKey());
        }
        return res;
    }
    public static void main(String args[]) {
        TopKFreq test = new TopKFreq();
        int[] input = {1,1,1,2,2,3};
        System.out.print(test.topKFrequent(input, 2));
    }
}
