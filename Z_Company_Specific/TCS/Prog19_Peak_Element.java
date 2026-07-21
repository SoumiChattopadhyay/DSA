/*
Peak Element
You are given an array arr[] where no two adjacent elements are same, find the index of a peak 
element. An element is considered to be a peak if it is greater than its adjacent elements (if they 
exist).

If there are multiple peak elements, Return index of any one of them. The output will be "true" if
the index returned by your function is correct; otherwise, it will be "false".

Note: Consider the element before the first element and the element after the last element to be 
negative infinity.

Examples :
Input: arr = [1, 2, 4, 5, 7, 8, 3]
Output: true
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].
*/
public class Prog19_Peak_Element {
    static int peakElement(int[] arr) {
        int low=0,high=arr.length-1;
        while(low<high){// We run the loop till < not till = becoz when low=high in the end then we will get the largest element
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[mid+1])//we are in descending part of the array and this descending part might or might not contain the peak element
                high=mid;
            else if(arr[mid]<arr[mid+1])//we are in ascending part of array and this ascending part does not contain the peak element
                low=mid+1;
           //in the end, low == high,so loop breaks and low & high point to the largest number because of the 2 checks above
           }
        return low;//or return high          
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
    }
}
