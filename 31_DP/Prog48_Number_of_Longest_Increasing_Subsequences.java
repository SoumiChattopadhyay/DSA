public class Prog48_Number_of_Longest_Increasing_Subsequences {
    static int funct(int[] arr, int n){
        int[] dp = new int[n];
        int[] count = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
        }

        int maxLen=0;
        for(int ind=0;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(arr[ind]>arr[prev] && 1+dp[prev]>dp[ind]){
                    dp[ind] = 1+dp[prev];
                    count[ind]=count[prev];//assign new value
                }
                else if(arr[ind]>arr[prev] && 1+dp[prev]==dp[ind]){
                    count[ind]+=count[prev];//add to existing value
                }
            }
            maxLen = Math.max(maxLen,dp[ind]);
        }

        int nos=0;//no. of LIS
        for(int i=0;i<n;i++){
            if(dp[i]==maxLen){
                nos+=count[i];
            }
        }

        return nos;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,4,3,2,6,7,10,8,9};
        int n=arr.length;
        System.out.println(funct(arr, n));
    }
}
