/*
Find Kth Rotation
Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k 
times. Find the value of k.
Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2 times it will look like 
this:
After 1st Rotation : [9, 2, 4, 6]
After 2nd Rotation : [6, 9, 2, 4]

Examples:

Input: arr[] = [5, 1, 2, 3, 4]
Output: 1
Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
*/
public class Prog23_Find_Kth_Rotation {
    static int findKRotation(int arr[]) {
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
        return low;
    }
    public static void main(String[] args) {
        int[] arr={6, 9, 2, 4};
        System.out.println(findKRotation(arr));
    }
}
/*
Key Observation:
In a right-rotated sorted array, the index of the minimum element = number of right rotations (k).
*/