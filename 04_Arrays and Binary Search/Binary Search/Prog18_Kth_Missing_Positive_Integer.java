/*
Problem Statement: You are given a strictly increasing array ‘vec’ and a positive 
integer 'k'. Find the 'kth' positive integer missing from 'vec'.

Example 1:
Input Format: vec[]={4,7,9,10}, k = 1
Result: 1
Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 1, the first missing element is 1.

Example 2:
Input Format: vec[]={4,7,9,10}, k = 4
Result: 5
Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 4, the fourth missing element is 5.
 */

public class Prog18_Kth_Missing_Positive_Integer {
    // Brute
    static int funct1(int[] arr, int k){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
    // Optimal
    static int funct2(int[] arr, int k){
        int n=arr.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int missing = arr[mid]-(mid+1);//gives the no. of missing els before index mid
            if(missing<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return k+high+1;//or low+k
    }
    public static void main(String[] args) {
        int[] arr = {4,7,9,10};//given array of increasing positive integers
        int k=4;
        System.out.println(funct1(arr, k));
        System.out.println(funct2(arr, k));
    }
}
// mid = (0+3)/2 = 1
// 7 - 2 = 5 missing els(1,2,3,5,6)
// 5 > k=4 => So, high = mid-1 = 1-1 = 0
// mid = (0+0)/2 = 0
// 4 - 1 = 3 missing els(1,2,3)
// 3 < k=4 => So, low = mid+1 = 0+1 = 1
// low=1, high=0 loop stops
// So: low = (first index where missing >= k) = 1
// So ans is k+high+1 i.e. 4+0+1=5 or  low+k i.e. 1+4=5