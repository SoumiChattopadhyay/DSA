// https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
public class Prog44_Length_of_Longest_Continuous_Increasing_Subsequence {
    // This is not LIS or DP problem its a separate Leetcode problem
    static int findLengthOfLCIS(int[] arr) {
        int n = arr.length;
        int maxlen=1;
        int currlen=1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                currlen++;
            }else{
                currlen=1;
            }
            maxlen = Math.max(maxlen,currlen);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(arr));
    }
    
}
