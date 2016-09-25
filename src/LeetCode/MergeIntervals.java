package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yuliu on 8/30/16.
 *///Given a collection of intervals, merge all overlapping intervals
public class MergeIntervals {
    static class Interval{
        int start;
        int end;
        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new MyComparator());
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (cur.end < temp.start) {//it means no overlapping
                res.add(cur);
                cur = temp;
            } else {
                cur =  new Interval(cur.start, Math.max(temp.end, cur.end));
            }
        }
        res.add(cur);
        System.out.print("My res:" + res);
        return res;
    }
    static class MyComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
    public static void main(String args[]) {
        MergeIntervals test = new MergeIntervals();
        Interval one = new Interval(8, 10);
        Interval two = new Interval(2, 6);
        Interval three = new Interval(1, 3);
        List<Interval> inputList = new ArrayList<>();
        inputList.add(one);
        inputList.add(two);
        inputList.add(three);
        System.out.print(test.merge(inputList));
    }
}
