/*
You are given an array arr[] of size n - 1 that contains distinct integers in the range from 
1 to n (inclusive). This array represents a permutation of the integers from 1 to n with one 
element missing. Your task is to identify and return the missing element.
*/
//TC=O(N), SC=O(1)
public class Prog08_Missing_in_Array {
    static int findMissingEl(int[] arr){
        int n=arr.length+1;//Important it must be n+1 not n
        long Sn = (long)n*(n+1)/2;
        long S = 0;
        for(int el:arr)
            S+=el;
        int ans = (int)(Sn-S);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(findMissingEl(arr));
    }
}
/*
Algorithm :
1. Calculate the expected sum of numbers from 1 to n:
    Expected Sum = n(n+1)/2
2. Calculate the sum of all elements in the array.
3. The missing element is: 
    Missing = Expected Sum − Array Sum
*/