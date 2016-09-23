package basic3;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by yuliu on 7/5/16.
 */
//A point represents a location in (x,y) coordinate space specified in integer precision
    //point() constructs and initialize a point at the specified (x,y) location in the coordinate space
    //point(Point p) constructs and initializes a point with the same location as the specified point object.
public class MostPointsOnALine {
    public int most(Point[] points) {
        //use result to record the maximum number of points on the same line
        int result = 0;
        //we use each pair of points to form a line
        for (int i = 0; i < points.length; i++) {
            //any line can be represented by a point and a slope
            //we take the point as seed and try to find all possible slopes.
            Point seed = points[i];
            int same = 1; //record points with smae<x,y>.
            int sameX = 0;//for the number with same x
            int most = 0;//record max number of points on the same line
            HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                Point tmp = points[j];
                if (tmp.x == seed.x && tmp.y == seed.y) {
                    same++;
                } else if (tmp.x == seed.x) {
                    sameX++;
                } else {
                    double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
                    if (!cnt.containsKey(slope)) {
                        cnt.put(slope, 1);
                    } else {
                        cnt.put(slope, cnt.get(slope) + 1);
                    }
                    most = Math.max(most, sameX) + same;
                    result = Math.max(result, most);
                }
            }
        }
        return result;
    }
}
