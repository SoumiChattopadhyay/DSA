import java.util.Arrays;

public class Prog43_Length_of_Longest_Increasing_Subsequence {
    // Recursion
    static int funct1(int ind, int prev_ind, int[] arr, int n){
        // Base Case
        if(ind==n) return 0;

        int len=0;
        //not-pick case
        len = 0 + funct1(ind+1, prev_ind, arr, n);
        // pick case
        if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
            len = Math.max(len, 1 + funct1(ind+1, ind, arr, n));//len stores the max of pick and notpick case answers
        }

        return len;
    }
    // Memoization
    static int funct2(int ind, int prev_ind, int[][] dp, int[] arr, int n){
        // Base Cases
        if(ind==n) return 0;
        if(dp[ind][prev_ind+1]!=-1) return dp[ind][prev_ind+1];

        int len=0;
        //not-pick case
        len = 0 + funct2(ind+1, prev_ind, dp, arr, n);
        // pick case
        if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
            len = Math.max(len, 1 + funct2(ind+1, ind, dp, arr, n));//len stores the max of pick and notpick case answers
        }

        return dp[ind][prev_ind+1] = len;
    }
    // Tabulation
    static int funct3(int[][] dp, int[] arr, int n){
        // Base Case
        for(int prev_ind=0;prev_ind<n+1;prev_ind++)
            dp[n][prev_ind]=0;

        for(int ind=n-1;ind>=0;ind--){
            for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--){//prev_ind cannot be beyond index or on index itself it has to be before it
                int len=0;
                //not-pick case
                len = 0 + dp[ind+1][prev_ind+1];//2nd paramter in dp will always have + 1.
                // pick case
                if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
                    len = Math.max(len, 1 + dp[ind+1][ind+1]);//2nd paramter in dp will always have + 1. Here ind+1 actually represents ind
                }
                dp[ind][prev_ind+1] = len;//2nd paramter in dp will always have + 1.
            }
        }
        return dp[0][-1+1];
    }
    // Space Optimization
    static int funct4(int[] arr, int n){
        int[] afterRow = new int[n+1];
        int[] currRow = new int[n+1];
        // Base Case
        for(int prev_ind=0;prev_ind<n+1;prev_ind++)
            afterRow[prev_ind]=0;

        for(int ind=n-1;ind>=0;ind--){
            currRow = new int[n+1];
            for(int prev_ind=ind-1;prev_ind>=-1;prev_ind--){//prev_ind cannot be beyond index or on index itself it has to be before it
                int len=0;
                //not-pick case
                len = 0 + afterRow[prev_ind+1];//2nd paramter in dp will always have + 1 (coordinate shifting).
                // pick case
                if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
                    len = Math.max(len, 1 + afterRow[ind+1]);//2nd paramter in dp will always have + 1 (coordinate shifting). Here ind+1 actually represents ind
                }
                currRow[prev_ind+1] = len;//2nd paramter in dp will always have + 1 (coordinate shifting).
            }
            afterRow=currRow;
        }
        return afterRow[-1+1];
    }
    // Ṭabulation (Better Approach)
    static int funct5(int[] arr, int n){
        int[] dp = new int[n];
        for(int ind=0;ind<n;ind++) 
            dp[ind]=1;
        int maxi=1;//dont take it 0, LIS length in will be 1 atleast
        for(int ind=0;ind<n;ind++){
            for(int prev_ind=0;prev_ind<=ind-1;prev_ind++){
                if(arr[prev_ind]<arr[ind]){
                    dp[ind] = Math.max(1+dp[prev_ind],dp[ind]);
                }
            }
            maxi=Math.max(dp[ind],maxi);//track maximum LIS
        }
        return maxi;
    }
    // Returning the LIS 
    static int[] funct6(int[] arr, int n){
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int ind=0;ind<n;ind++){
            dp[ind]=1;
        }
            
        int maxi=1;
        int lastIdx=0;
        for(int ind=0;ind<n;ind++){
            hash[ind]=ind;
            for(int prev_ind=0;prev_ind<=ind-1;prev_ind++){
                if(arr[prev_ind]<arr[ind] && 1+dp[prev_ind]>dp[ind]){
                    dp[ind]=1+dp[prev_ind];
                    hash[ind]=prev_ind;
                }                
            }
            if(dp[ind]>maxi){
                maxi=dp[ind];//LIS length
                lastIdx=ind;//last index where LIS ends
            }
        }
        int[] lis = new int[maxi];
        lis[0] = arr[lastIdx];
        int ind=1;
        while(hash[lastIdx]!=lastIdx){//This loop means Keep going back until you reach the idx which is prev of itself(pointing to itself) i.e. the idx which stores the starting el of the LIS.
            lastIdx = hash[lastIdx];
            lis[ind++] = arr[lastIdx];
        }
        // Reverse the array
        for(int i=0,j=lis.length-1;i<j;i++,j--){//when i=j what are u gonna swap? nothing! so run the loop until i is less than j
            int temp = lis[i];
            lis[i] = lis[j];
            lis[j] = temp;
        }
        return lis;
    }
    //Find length of LIS Using Binary Search (Best approach)
    static int funct7(int[] arr, int n){
        int[] temp = new int[n];
        temp[0]=arr[0];
        int len=1;
        for(int i=1;i<n;i++){
            if(arr[i]>temp[len-1]){//temp is not built according to index i. It only has valid values till len - 1. So temp[i-1] is wrong, temp[len-1] is correct. 
                temp[len]=arr[i];//temp is not built according to index i. It only has valid values till len - 1. So temp[i] is wrong, temp[len] is correct.
                len++;
            }
            else{
                int ind = binarySearch(arr[i], temp, 0, len-1);//temp is not built according to index i. It only has valid values till len - 1. So i-1 is wrong, len-1 is correct. 
                temp[ind]=arr[i];
            }
        }
        return len;
    }
    /*
    len = current length of LIS
    So Valid temp indices are: 0  →  len-1
    So if len = 4, Valid positions are: 0, 1, 2, 3
    
    Use len - 1 when You are looking at the last valid element.
    Example:
        if(arr[i] > temp[len - 1])
    Why? Because you want to check: Is current element bigger than the last element of the current LIS? 
        
    Use len when You are adding a new element at the end.
    Example:
        temp[len] = arr[i];
        len++;
    Why? Because the next free position is exactly at index len.

    You have already declared temp of size n so there will be no Out of Bounds error 
    
    
    One-Line Memory Trick
        len - 1 → last valid element
        len → next empty position */
    static int binarySearch(int search, int[] temp, int lb, int ub){//lb means lower bound(or start or left) ub means upper bound(or end or right)
        while(lb<=ub){
            int mid = lb+(ub-lb)/2;
            if(temp[mid]==search) 
                return mid;
            else if(search<temp[mid])
                ub=mid-1;
            else
                lb=mid+1;
        }
        return lb;
    }
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int n=arr.length;
        System.out.println(funct1(0, -1, arr, n));

        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(0, -1, dp, arr, n));

        dp = new int[n+1][n+1];
        System.out.println(funct3(dp, arr, n));

        System.out.println(funct4(arr, n));

        arr=new int[]{5,4,11,1,16,8};
        n=arr.length;
        System.out.println(funct5(arr, n));

        System.out.println(Arrays.toString(funct6(arr, n)));

        arr = new int[]{1,7,8,4,5,6,-1,9};
        n=arr.length;
        System.out.println(funct7(arr, n)); 

        arr = new int[]{10,9,2,5,3,7,101,18};
        n=arr.length;
        System.out.println(funct7(arr, n));
    }
}
