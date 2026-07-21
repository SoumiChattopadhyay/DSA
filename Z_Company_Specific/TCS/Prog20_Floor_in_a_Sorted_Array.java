/*
Floor in a Sorted Array
Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in 
arr[] that is less than or equal to x. This element is called the floor of x. If such an element 
does not exist, return -1.

Note: In case of multiple occurrences of floor of x, return the index of the last occurrence.

Examples

Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
Output: 1
Explanation: Largest number less than or equal to 5 is 2, whose index is 1.

What is Floor?
The floor of x is the largest element ≤ x.

*/
public class Prog20_Floor_in_a_Sorted_Array {
    static int findFloor(int[] arr, int x) {
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=x){
                ans=mid;//possible answer
                low=mid+1;// search for a larger valid floor
            }
            else{
                high=mid-1;
            }
        }
        return ans;        
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x=5;
        System.out.println(findFloor(arr, x));
    }
}
