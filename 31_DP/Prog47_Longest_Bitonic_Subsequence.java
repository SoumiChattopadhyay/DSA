public class Prog47_Longest_Bitonic_Subsequence {
    static int funct(int[] arr, int n){
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i=0;i<n;i++){
            dp1[i]=1;
            dp2[i]=1;
        }
        for(int ind=0;ind<n;ind++){
            for(int prev_ind=0;prev_ind<=ind-1;prev_ind++){
                if(arr[ind]>arr[prev_ind] && 1+dp1[prev_ind]>dp1[ind]){
                    dp1[ind]=1+dp1[prev_ind];
                }
            }
        }

        for(int ind=n-1;ind>=0;ind--){
            for(int prev_ind=n-1;prev_ind>=ind+1;prev_ind--){
                if(arr[ind]>arr[prev_ind] && 1+dp2[prev_ind]>dp2[ind]){
                    dp2[ind]=1+dp2[prev_ind];
                }
            }
        }

        int maxi=1;
        for(int ind=0;ind<n;ind++){
            maxi = Math.max(maxi,dp1[ind]+dp2[ind]-1);
        }

        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {1,11,2,10,4,5,2,1};
        int n = arr.length;
        System.out.println(funct(arr, n));
    }
}
