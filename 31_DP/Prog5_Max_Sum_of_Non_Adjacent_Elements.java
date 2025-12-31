// Given an array of N numbers, return the maximum sum of the subsequence 
// with the constraint that no two elements are adjacent in the given array
public class Prog5_Max_Sum_of_Non_Adjacent_Elements {
    // Recursion
    static int funct(int[] arr,int idx){
        if(idx==0) return arr[idx];
        if(idx<0) return 0;
        int pick = arr[idx]+funct(arr,idx-2);
        int notPick = 0+funct(arr,idx-1);
        return Math.max(pick,notPick);
    }
    // Memoization
    static int funct2(int[] arr,int idx,int[]dp){
        if(idx==0) return arr[idx];
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int pick = arr[idx]+funct(arr,idx-2);
        int notPick = 0+funct(arr,idx-1);
        return dp[idx]=Math.max(pick,notPick);
    }
    // Tabulation
    static int funct3(int[] arr,int idx,int[] dp){
        dp[0]=arr[0];
        int pick=Integer.MIN_VALUE, notPick=Integer.MIN_VALUE;
        for(int i=1;i<=idx;i++){
            pick = arr[i]; if(i>1) pick+=+dp[i-2];
            notPick = 0+dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[idx];
    }
    // Space Optimization
    static int funct4(int[] arr,int idx){
        int prev2=0;
        int prev=arr[0];
        int curr=Integer.MIN_VALUE,pick=Integer.MIN_VALUE, notPick=Integer.MIN_VALUE;
        for(int i=1;i<=idx;i++){
            pick=arr[i];
            if(i>1) 
                pick+=prev2;
            notPick=0+prev;
            curr=Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,4,9};
        int n=arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i]=-1;
        System.out.println(funct(arr,n-1));
        System.out.println(funct2(arr,n-1,dp));
        System.out.println(funct3(arr,n-1,dp));
        System.out.println(funct4(arr,n-1));
    }
}
