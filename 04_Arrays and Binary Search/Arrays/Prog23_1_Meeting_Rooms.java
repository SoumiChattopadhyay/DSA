/*
Given an array of meeting time interval objects consisting of start and end times 
[[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all 
meetings to their schedule without any conflicts. The intervals may be provided in any order.

Note: (0,8),(8,10) is not considered a conflict at 8
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Definition of Interval
class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Prog23_1_Meeting_Rooms {
    // Method to check if a person can attend all meetings
    public static boolean canAttendAllMeetings(List<Interval> intervals) {
        if (intervals==null||intervals.size()<=1){
            return true;
        }

        // 1. Sort intervals by start time in ascending order
        intervals.sort((a,b)->Integer.compare(a.start,b.start));

        // 2. Check adjacent intervals for overlap
        for (int i=1;i<intervals.size();i++) {
            Interval prev = intervals.get(i-1);
            Interval curr = intervals.get(i);

            // Overlap occurs if current meeting starts before the previous one ends
            if (curr.start<prev.end) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        // Example 1: [(0, 30), (5, 10), (15, 20)] -> Expected: false
        List<Interval> example1 = new ArrayList<>(Arrays.asList(
            new Interval(0, 30),
            new Interval(5, 10),
            new Interval(15, 20)
        ));
        System.out.println("Example 1 Result: " + canAttendAllMeetings(example1));

        // Example 2: [(5, 8), (9, 15)] -> Expected: true
        List<Interval> example2 = new ArrayList<>(Arrays.asList(
            new Interval(5, 8),
            new Interval(9, 15)
        ));
        System.out.println("Example 2 Result: " + canAttendAllMeetings(example2));

        // Edge Case: Adjacent meetings sharing endpoint (0,8) and (8,10) -> Expected: true
        List<Interval> example3 = new ArrayList<>(Arrays.asList(
            new Interval(0, 8),
            new Interval(8, 10)
        ));
        System.out.println("Example 3 Result: " + canAttendAllMeetings(example3));
    }
}