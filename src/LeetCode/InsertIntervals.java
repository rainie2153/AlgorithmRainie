package LeetCode;

import java.util.*;

/**
 * Created by yuliu on 8/30/16.
 */
public class InsertIntervals {
    static class Interval{
        int start;
        int end;
        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if ((intervals == null || intervals.size() == 0) && newInterval == null) {
            return res;
        }
        if ((intervals == null || intervals.size() == 0) && newInterval != null) {
            return Arrays.asList(newInterval);
        }

        Collections.sort(intervals, new MyComparator());

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {//no overlap
                res.add(interval);
            } else if (interval.end >= newInterval.start && newInterval.end >= interval.start) {
                int newStart = Math.min(interval.start, newInterval.start);
                int newEnd = Math.max(interval.end, newInterval.end);
                newInterval = new Interval(newStart, newEnd);
            } else {
                res.add(newInterval);//也是no overlap但是新insert的这个interval都是在所有intervals 的前面
                newInterval = interval;
            }
        }
        res.add(newInterval);
        return res;
    }
    static class MyComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
    public static void main(String args[]) {
//        String[] arr = {"1","9","6","3"};
//        //Arrays.sort(arr);
//        List<String> list = new ArrayList<String>(Arrays.asList(arr));
//        list.add("-1");
//        list.add("2");
//        list.add("100");
//        Collections.sort(list);

        InsertIntervals test = new InsertIntervals();
        Interval one = new Interval(7, 9);
        Interval two = new Interval(1, 3);
        //Interval three = new Interval(1, 3);
        List<Interval> inputList = new ArrayList<>();
        inputList.add(one);
        inputList.add(two);
        //inputList.add(three);
        Interval newInterval = new Interval(2, 5);
        test.insert(inputList, newInterval);

    }
}
