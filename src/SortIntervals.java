import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortIntervals {
    public static void main(String []args) {
        int [][]intervals = {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        int [][] mergedIntervals = mergeIntervals(intervals);
        for(int []interval: mergedIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    private static void sortIntervals(int [][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
    }

    private static int[][] mergeIntervals(int [][]intervals) {
        if(null == intervals || intervals.length == 0)
            return intervals;
        sortIntervals(intervals);

        List<int[]> mergedIntervals = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                mergedIntervals.add(new int[]{start, end});
                start = intervals[i][0];
                end = Math.max(end, intervals[i][1]);
            }
            end = Math.max(end, intervals[i][1]);
        }

        mergedIntervals.add(new int[]{start, end});

        int [][]result = new int[mergedIntervals.size()][];
        for(int i = 0; i < result.length; i++) {
            result[i] = mergedIntervals.get(i);
        }
        return result;
    }
}
