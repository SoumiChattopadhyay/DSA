/*
First Occurrence in Sorted
Given a sorted array arr[] and an integer k, find the position(0-based indexing) at which k is present in the array using binary search. If k doesn't exist in arr[] return -1. 

Note: If multiple occurrences are there, please return the smallest index.

Examples:

Input: arr[] = [1, 2, 3, 4, 5], k = 4
Output: 3
Explanation: 4 appears at index 3.
*/
public class Prog18_First_Occurrence {
    static int firstSearch(int[] arr, int k) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(k<=arr[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if (low < arr.length && arr[low] == k)
            return low;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5};
        int k=4;
        System.out.println(firstSearch(arr,k));
    }
}
