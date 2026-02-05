import java.util.Arrays;

public class Prog18_Count_Subsets_whose_Sum_equal_to_Target {
    // Recursion
    static int funct(int ind, int sum, int[] arr){
        // Base Cases
        if(sum==0) return 1;
        if(ind==0) return (arr[ind]==sum)?1:0;

        int notpick = funct(ind-1, sum, arr);
        int pick = 0;
        if(arr[ind]<=sum){
            pick = funct(ind-1, sum-arr[ind], arr);
        }
        return pick+notpick;
    }
    // Memoization
    static int funct2(int ind, int sum,int[][] dp, int[] arr){
        // Base Cases
        if(sum==0) return 1;
        if(ind==0) return (arr[ind]==sum)?1:0;
        if(dp[ind][sum]!=-1) return dp[ind][sum];

        int notpick = funct2(ind-1, sum, dp, arr);
        int pick = 0;
        if(arr[ind]<=sum){
            pick = funct2(ind-1, sum-arr[ind], dp, arr);
        }
        return dp[ind][sum] = pick+notpick;
    }
    // Tabulation
    static int funct3(int N, int tar,int[][] dp, int[] arr){
        // Base Cases
        for(int i=0;i<N;i++){
            dp[i][0]=1;
        }
        if(arr[0]<=tar) dp[0][arr[0]]=1;
        print_Dp_table(dp);

        for(int ind=1;ind<N;ind++){
            for(int sum=0;sum<=tar;sum++){
                int notpick = dp[ind-1][sum];
                int pick=0;
                if(arr[ind]<=sum){
                    pick = dp[ind-1][sum-arr[ind]];
                }
                dp[ind][sum] = pick + notpick;
            }
        }
        return dp[N-1][tar];
    }

    // Space Optimization
    static int funct4(int N, int tar,int[] arr){
        int[] prevRow=new int[tar+1];
        int[] currRow=new int[tar+1];
        // Base Cases
        prevRow[0]=currRow[0]=1;
        if(arr[0]<=tar) prevRow[arr[0]]=1;

        for(int ind=1;ind<N;ind++){//base case was at 0 so start from 1
            currRow = new int[tar+1];
            currRow[0]=1;
            for(int sum=0;sum<=tar;sum++){
                int notpick = prevRow[sum];
                int pick=0;
                if(arr[ind]<=sum){
                    pick = prevRow[sum-arr[ind]];
                }
                currRow[sum] = pick + notpick;
            }
            prevRow=currRow;
        }
        return prevRow[tar];
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,3};
        int sum=3;
        // int[] arr={0,1,2};
        // int sum=0;
        // int[] arr={1,2,3};
        // int sum=3;
        int n=arr.length;
        System.out.println(funct(n-1, sum, arr));

        int[][] dp = new int[n][sum+1];
        for(int i=0;i<n;i++){
            for(int k=0;k<=sum;k++){
                dp[i][k]=-1;
            }
        }
        System.out.println(funct2(n-1, sum, dp, arr));

        for(int i=0;i<n;i++){
            for(int k=0;k<=sum;k++){
                dp[i][k]=0;//since we are doing addition -1 might decrease value
            }
        }
        System.out.println(funct3(n, sum, dp, arr));
        // print_Dp_table(dp);
        System.out.println(funct4(n, sum, arr));
    }
    
    static void print_Dp_table(int[][] dp){
        int c=0;
        System.out.println("Printing the dp table:");
        System.out.println("   0  1  2  3 ");
        for(int[] a:dp){
            System.out.println(c++ +" "+Arrays.toString(a));
        }
    }
}
