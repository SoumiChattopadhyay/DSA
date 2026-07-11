/*
Meeting Rooms II

Given an array of meeting time interval objects consisting of start and end times 
[[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of rooms required 
to schedule all meetings without any conflicts.

Note: (0,8),(8,10) is NOT considered a conflict at 8.

Example 1:
Input: intervals = [(0,40),(5,10),(15,20)]
Output: 2
Explanation:
room1: (0,40)
room2: (5,10),(15,20)

Example 2:
Input: intervals = [(4,9)]
Output: 1

Constraints:
0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000 */

// We are asked to find minimum number of rooms required which is the same as finding the maximum number of overlapping meetings at any given point of time

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prog23_Meeting_Rooms_II {
    // Definition of Interval:
    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<n;i++){
            start[i]=intervals.get(i).start;
            end[i] = intervals.get(i).end;
        } 
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms=0;
        int count=0;
        int s=0,e=0;
        while(s<n){
            if(start[s]<end[e]){
                // New meeting begins before any room becomes free
                s++;
                count++;
            }else{
                // A meeting has ended
                e++;
                count--;
            }
            rooms=Math.max(rooms,count);
        }
        return rooms;
    }
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();//{{0,40},{5,10},{15,20}};
        Prog23_Meeting_Rooms_II obj = new Prog23_Meeting_Rooms_II();
        intervals.add(obj.new Interval(0, 40));
        intervals.add(obj.new Interval(5, 10));
        intervals.add(obj.new Interval(15, 20));
        System.out.println(minMeetingRooms(intervals));
    }
}
