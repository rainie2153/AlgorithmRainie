package basic2;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by yuliu on 6/18/16.
 */
public class TopFrequent {
    public String[] topFrequent(String[] combo, int k) {
        if (combo.length == 0) return new String[0];
        Map<String, Integer> freqMap = getFreqMap(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            }else if(entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return freqArray(minHeap);

    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : combo) {
            Integer freq = freqMap.get(s);
            if (freq == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, ++freq);
            }
        }
        System.out.print(freqMap);
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() -1;i>=0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        //[a, c, b]
        //return result;
        //  System.out.print(result);
        return result;
    }

    public static void main(String[] args) {
        TopFrequent test = new TopFrequent();
        String[] s = {"a", "a", "a", "b", "c", "c"};
        String[] res = test.topFrequent(s, 3);
        for (String str : res) {
            System.out.print(str);
        }
    }
 }
