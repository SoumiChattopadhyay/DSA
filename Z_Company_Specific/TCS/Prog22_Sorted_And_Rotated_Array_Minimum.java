/*
Sorted and Rotated Minimum
A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find 
the minimum element in it. 
Examples:
Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element in the array.
*/
public class Prog22_Sorted_And_Rotated_Array_Minimum {
    static int findMin(int[] arr) {
        int low=0,high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[high]){//minimum el must be on the right, so do low=mid+1
                low=mid+1;
            }
            else {//if arr[mid]<arr[high] //minimum el must be on the left, so do high=mid
                high=mid;
            }
        }
        return arr[low];
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}