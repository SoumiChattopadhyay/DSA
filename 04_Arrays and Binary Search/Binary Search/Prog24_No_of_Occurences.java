/*
Given a sorted array arr[] and a number target, find the number of occurrences of target in given array. 

Examples:
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
*/
public class Prog24_No_of_Occurences {
    static int countFreq(int[] arr, int target) {
        // code here
        // Since the array is sorted, the optimal solution is Binary Search.
        // no. of occurences = last occurence index - first occurence index + 1
        int firstOccurenceIdx=firstOccurence(arr, target);
        int lastOccurenceIdx=lastOccurence(arr, target);
        if(firstOccurenceIdx==-1) return 0;
        int occurences = lastOccurenceIdx - firstOccurenceIdx + 1;
        return occurences;
    }
    static int firstOccurence(int[] arr, int target){
        int low=0,high=arr.length-1;
        int firstOccurenceIdx=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                firstOccurenceIdx=mid;
                high=mid-1;//search more left
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return firstOccurenceIdx;
    }
    static int lastOccurence(int[] arr, int target){
        int low=0,high=arr.length-1;
        int lastOccurenceIdx=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                lastOccurenceIdx=mid;
                low=mid+1;//search more right
            }
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return lastOccurenceIdx;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println(countFreq(arr, target));
    }
}
