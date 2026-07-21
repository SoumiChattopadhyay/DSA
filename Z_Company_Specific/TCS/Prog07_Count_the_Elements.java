/*
Count the Elements
Given two arrays a and b both of size n. Given q queries in an array query each having a 
positive integer x denoting an index of the array a. For each query, your task is to find all 
the elements less than or equal to a[x] in the array b.

Example 1:
Input:
n = 3
a[] = {4,1,2}
b[] = {1,7,3}
q = 2
query[] = {0,1}
Output : {2,1}
Explanation: 
For 1st query, the given index is 0, a[0] = 4. There are 2 elements(1 and 3) which are less than or equal to 4.
For 2nd query, the given index is 1, a[1] = 1. There exists only 1 element(1) which is less than or equal to 1.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Prog07_Count_the_Elements {
    static int[] countEls(int[] a, int[] b, int[] query, int n, int q){
        // Step 1: Sort array b
        Arrays.sort(b);
        // Step 2: For each query, binary search on b
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<q;i++){
            int idx=query[i];
            int target=a[idx];
            ans.add(countLessOrEqual(b,target));
        }
        int[] result = new int[ans.size()];
        for(int i=0;i<ans.size();i++) 
            result[i]=ans.get(i);
        return result;
    }
    // Returns count of elements in sorted array that are <= target
    static int countLessOrEqual(int[] b, int target){
        int low=0;
        int high=b.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(b[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low; // stores no. of elements <= target
    }
    public static void main(String[] args) {
        int[] a = {4,1,2};
        int[] b = {1,7,3};
        int[] query = {0,1};
        int n = a.length;//or b.length
        int q = query.length;
        System.out.println(Arrays.toString(countEls(a, b, query, n, q)));
    }
}
/*
Approach:
1. Sort array b – once sorted, we can binary search on it.
2. For each query index x, we need the count of elements in b that are ≤ a[x].
3. This is exactly upper_bound(b, a[x]) — the number of elements in sorted b that are less than or equal to a[x].


Since b is sorted once and each query only does a binary search (O(log n)), the total complexity becomes efficient even for many queries.

Complexity
Sorting b: O(n log n)
Each query: O(log n) via binary search
Total: O(n log n + q log n) — much better than the naive O(n*q).
*/