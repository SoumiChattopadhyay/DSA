public class Prog53_Boolean_Evaluation_to_True_with_Modulo {
    static int mod = 1000000007;
     // Recursion
    static long funct1(int i, int j, int isTrue, String exp){
        // Base Cases
        if(i>j) return 0; //1st base case isnt necessary I guess because 2nd base case already handles the smallest possible substring
        if(i==j){
            if(isTrue==1) return exp.charAt(i)=='T'?1:0;
            else return exp.charAt(i)=='F'?1:0;
        }

        long ways=0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            long lT = funct1(i, ind-1, 1, exp);
            long lF = funct1(i, ind-1, 0, exp);
            long rT = funct1(ind+1, j, 1, exp);
            long rF = funct1(ind+1, j, 0, exp);

            if(exp.charAt(ind)=='&'){
                if(isTrue==1) ways = (ways+(lT*rT)%mod)%mod;
                else ways = (ways+(lT*rF)%mod + (lF*rT)%mod + (lF*rF)%mod)%mod;
            }
            else if(exp.charAt(ind)=='|'){
                if(isTrue==1) ways = (ways+(lT*rF)%mod + (lF*rT)%mod + (lT*rT)%mod)%mod;
                else ways = (ways+(lF*rF)%mod);
            }
            else{
                if(isTrue==1) ways = (ways+(lT*rF)%mod + (lF*rT)%mod)%mod;
                else ways = (ways+(lF*rF)%mod + (lT*rT)%mod)%mod;
            }
        }
        return ways;
    }

    // Memoization
    static long funct2(int i, int j, int isTrue, long[][][] dp, String exp){
        // Base Cases
        if(i>j) return 0; //1st base case isnt necessary I guess because 2nd base case already handles the smallest possible substring
        if(i==j){
            if(isTrue==1) return exp.charAt(i)=='T'?1:0;
            else return exp.charAt(i)=='F'?1:0;
        }
        if(dp[i][j][isTrue]!=-1)
            return dp[i][j][isTrue];

        long ways=0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            long lT = funct1(i, ind-1, 1, exp);
            long lF = funct1(i, ind-1, 0, exp);
            long rT = funct1(ind+1, j, 1, exp);
            long rF = funct1(ind+1, j, 0, exp);

            if(exp.charAt(ind)=='&'){
                if(isTrue==1) ways = (ways+(lT*rT)%mod)%mod;
                else ways = (ways+(lT*rF)%mod + (lF*rT)%mod + (lF*rF)%mod)%mod;
            }
            else if(exp.charAt(ind)=='|'){
                if(isTrue==1) ways = (ways+(lT*rF)%mod + (lF*rT)%mod + (lT*rT)%mod)%mod;
                else ways = (ways+(lF*rF)%mod);
            }
            else{
                if(isTrue==1) ways = (ways+(lT*rF)%mod + (lF*rT)%mod)%mod;
                else ways = (ways+(lF*rF)%mod + (lT*rT)%mod)%mod;
            }
        }
        return dp[i][j][isTrue]=ways;
    }

    // Tabulation
    static long funct3(long[][][] dp, String exp, int n){
        // Base Cases
        for(int i=0;i<n;i++){
            dp[i][i][0] = exp.charAt(i)=='F'?1:0;
            dp[i][i][1] = exp.charAt(i)=='T'?1:0;
        }
    
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=n-1;j++){
                if(i==j) continue;//avoid recomputing base cases
                for(int isTrue=0;isTrue<=1;isTrue++){
                    long ways=0;
                    for(int ind=i+1;ind<=j-1;ind+=2){
                        long lT = dp[i][ind-1][1];
                        long lF = dp[i][ind-1][0];
                        long rT = dp[ind+1][j][1];
                        long rF = dp[ind+1][j][0];

                        if(exp.charAt(ind)=='&'){
                            if(isTrue==1) ways = (ways+(lT*rT)%mod)%mod;
                            else ways = (ways+(lT*rF)%mod + (lF*rT)%mod + (lF*rF)%mod)%mod;
                        }
                        else if(exp.charAt(ind)=='|'){
                            if(isTrue==1) ways = (ways+(lT*rF)%mod + (lF*rT)%mod + (lT*rT)%mod)%mod;
                            else ways = (ways+(lF*rF)%mod);
                        }
                        else{
                            if(isTrue==1) ways = (ways+(lT*rF)%mod + (lF*rT)%mod)%mod;
                            else ways = (ways+(lF*rF)%mod + (lT*rT)%mod)%mod;
                        }
                    }
                    dp[i][j][isTrue]=ways;
                }
            }
        }
        return dp[0][n-1][1];       
    }
    public static void main(String[] args) {
        String exp = "T^F|T&F^T|F";
        int n = exp.length();
        System.out.println(funct1(0,n-1,1,exp));

        long[][][] dp = new long[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        }
        System.out.println(funct2(0,n-1,1,dp,exp));

        dp = new long[n][n][2];
        System.out.println(funct3(dp,exp, n));

    }
}
