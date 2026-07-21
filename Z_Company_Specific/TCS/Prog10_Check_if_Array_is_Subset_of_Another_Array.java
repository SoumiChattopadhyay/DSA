/*
Check if array is subset of another array
Problem Statement: Given arr1[] and arr2[], we need to find whether arr1[] is a subset of 
arr2[]. An array is called a subset of another if all of its elements are present in the 
other array..

*/

import java.util.Arrays;

public class Prog10_Check_if_Array_is_Subset_of_Another_Array {
    
    // Function to check if arr1[] is a subset of arr2[]
    static boolean isSubset(int[] arr1, int m, int[] arr2, int n) {
        // Sort arr2[] for binary search
        Arrays.sort(arr2);
        
        // If arr1[] has more elements than arr2[], it cannot be a subset
        if (m > n) return false;
        
        // For each element in arr1[], check if it exists in arr2[]
        for (int i = 0; i < m; i++) {
            boolean present = binarySearch(arr1[i], arr2, n); // Check if arr1[i] is present in arr2[]

            // If any element from arr1[] is not present in arr2[], return false
            if (!present) return false;
        }

        // If all elements of arr1[] are found in arr2[], return true
        return true;
    }
    
    // Function to perform binary search to check if an element is present in the array
    static boolean binarySearch(int target, int[] arr2, int n){
        int start=0;
        int end = n - 1;
        // Perform binary search
        while (start <= end) {
            int mid = (start + end) / 2;

            // If element is found, return true
            if (arr2[mid] == target)
                return true;

            // If the element is greater than mid, search in the right half
            else if (arr2[mid] < target)
                start = mid + 1;

            // If the element is smaller than mid, search in the left half
            else
                end = mid - 1;
        }
        return false; // If the element is not found
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5, 2};
        int[] arr2 = {2, 4, 3, 1, 7, 5, 15};
        int m = arr1.length;
        int n = arr2.length;
        boolean ans = isSubset(arr1,m,arr2,n);
        if (ans) {
            System.out.println("arr1[] is a subset of arr2[]");
        } else {
            System.out.println("arr1[] is not a subset of arr2[]");
        }
    }
}
/*
Algorithm
We can improve the time complexity by using sorting and binary search.

First sort the arr2[] array.
Set a loop to traverse the elements of arr1[] 
Search for them in arr2[] using binary search( as arr2[] is sorted)
*/