package ZohoTest;

import java.util.Arrays;
import java.util.regex.Pattern;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        // Sorting the intervals based on the start point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[index][1]) {
                // Overlapping intervals, update the end point
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                // Non-overlapping interval found, move to next index
                index++;
                intervals[index] = intervals[i]; // Move the current interval to the next index
            }
        }
        return Arrays.copyOf(intervals, index + 1);
    }
    public static void main(String[] args) {
        int arr[][] = {{1,4},{2,5},{3,7},{6,10}};

        for(int num[] : merge(arr)){
            for(int n : num){
                System.out.print(n+" ");
            }
            System.out.println();
        }

    }
}
