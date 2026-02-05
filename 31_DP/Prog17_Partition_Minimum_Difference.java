public class Prog17_Partition_Minimum_Difference {
    // Tabulation
    static boolean funct3(int N, int K, boolean[][] dp, int[] arr){
        //Base Cases
        for(int i=0;i<=N-1;i++) 
            dp[i][0]=true;
        if(arr[0]<=K) dp[0][arr[0]]=true;
        
        for(int ind=1;ind<=N-1;ind++){
            for(int target=1;target<=K;target++){
                boolean nottake = dp[ind-1][target];
                boolean take=false;
                if(target>=arr[ind])
                    take = dp[ind-1][target-arr[ind]];

                dp[ind][target]=(nottake || take);
            }
        }
        return dp[N-1][K];
    }
    static int check3(int[] arr, int N){
        int totalSum=0;
        for(int i=0;i<N;i++){
            totalSum+=arr[i];
        }
        boolean[][] dp = new boolean[N][totalSum+1];
        funct3(N, totalSum, dp, arr);
        //last row of dp array contains true/false denoting if k in dp[n-1][k] is valid S1 or not
        int mini=(int)1e9,s1,s2;
        for(int k=0;k<=totalSum/2;k++){
            if(dp[N-1][k]){
                s1=k;
                s2=totalSum-s1;
                mini = Math.min(mini,Math.abs(s1-s2));//or Math.min(mini,Math.abs(totalSum - 2*i));
            }
        }
        return mini;
    }
    
    // Space Optimization
    static boolean[] funct4(int N, int K,boolean[] prevRow, int[] arr){
        boolean[] currRow = new boolean[K+1];
        //Base Cases
       prevRow[0]=currRow[0]=true;
       if(arr[0]<=K) prevRow[arr[0]]=true;

       for(int ind=1;ind<N;ind++){
            currRow = new boolean[K+1];
            currRow[0]=true;
            for(int target=1;target<=K;target++){
                boolean nottake = prevRow[target];
                boolean take=false;
                if(target>=arr[ind]){
                    take = prevRow[target-arr[ind]];
                }
                currRow[target] = take || nottake;
            }
            prevRow=currRow;
       }
       return prevRow;//In Java references are passed by value so whatever updations you do here in prevRow arent reflected in check4 function so return the modified prevRow array
    }
    static int check4(int[] arr, int N){
        int totalSum=0;
        for(int i=0;i<N;i++){
            totalSum+=arr[i];
        }
        boolean[] prevRow = new boolean[totalSum+1];
        prevRow = funct4(N, totalSum, prevRow,arr);
        //last row of dp array contains true/false denoting if k in dp[n-1][k] is valid S1 or not
        int mini=(int)1e9,s1,s2;
        for(int k=0;k<=totalSum/2;k++){
            if(prevRow[k]){
                s1=k;
                s2=totalSum-s1;
                mini = Math.min(mini,Math.abs(s1-s2));//or Math.min(mini,Math.abs(totalSum - 2*i));
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        // int[] arr={3,2,7};
        int[] arr={1,2,3,4};
        int N=arr.length;
        System.out.println(check3(arr, N));
        System.out.println(check4(arr, N));
    }
}
