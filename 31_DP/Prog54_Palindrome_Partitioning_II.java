public class Prog54_Palindrome_Partitioning_II { //Using Front Partition
    static boolean isPalindrome(int i, int j, String str){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Recursion
    static int funct1(int i, String str, int n){
        // Base Case
        if(i==n) return 0;

        int minCost=Integer.MAX_VALUE;
        // i...j
        for(int j=i;j<n;j++){
            if(isPalindrome(i, j, str)){
                int cost = 1 + funct1(j+1, str, n);
                minCost = Math.min(cost,minCost);
            }
        }

        return minCost;
    }
    static int helper1(String str){
        int n = str.length();
        return funct1(0, str, n)-1;
    }


    // Memoization
    static int funct2(int i, int[] dp, String str, int n){
        // Base Cases
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];

        int minCost=Integer.MAX_VALUE;
        // i...j
        for(int j=i;j<n;j++){
            if(isPalindrome(i, j, str)){
                int cost = 1 + funct2(j+1, dp, str, n);
                minCost = Math.min(cost,minCost);
            }
        }

        return dp[i]=minCost;
    }
    static int helper2(String str){
        int n = str.length();
        int[] dp = new int[n];
        for(int i=0;i<n;i++) 
            dp[i]=-1;

        return funct2(0, dp, str, n)-1;
    }


    // Tabulation
    static int funct3(int[] dp, String str, int n){
        // Base Cases
        dp[n]=0;

        for(int i=n-1;i>=0;i--){
            int minCost=Integer.MAX_VALUE;
            // i...j
            for(int j=i;j<n;j++){
                if(isPalindrome(i, j, str)){
                    int cost = 1 + funct2(j+1, dp, str, n);
                    minCost = Math.min(cost,minCost);
                }
            }
            dp[i]=minCost;
        }
        
        return dp[0]-1;
    }  
    static int helper3(String str){
        int n = str.length();
        int[] dp = new int[n+1];

        return funct3(dp, str, n);
    }

    public static void main(String[] args) {
        String str = "bababcbadcede";
        System.out.println(helper1(str));
        System.out.println(helper2(str));
        System.out.println(helper3(str));
    }
}
