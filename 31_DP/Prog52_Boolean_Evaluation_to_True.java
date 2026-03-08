public class Prog52_Boolean_Evaluation_to_True {
    // Recursion
    static int funct1(int i, int j, int isTrue, String exp){
        // Base Cases
        if(i>j) return 0; //1st base case isnt necessary I guess because 2nd base case already handles the smallest possible substring
        if(i==j){
            if(isTrue==1) return exp.charAt(i)=='T'?1:0;
            else return exp.charAt(i)=='F'?1:0;
        }

        int ways=0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            int lT = funct1(i, ind-1, 1, exp);
            int lF = funct1(i, ind-1, 0, exp);
            int rT = funct1(ind+1, j, 1, exp);
            int rF = funct1(ind+1, j, 0, exp);

            if(exp.charAt(ind)=='&'){
                if(isTrue==1) ways += lT*rT;
                else ways += (lT*rF) + (lF*rT) + (lF*rF);
            }
            else if(exp.charAt(ind)=='|'){
                if(isTrue==1) ways += (lT*rF) + (lF*rT) + (lT*rT);
                else ways += (lF*rF);
            }
            else{
                if(isTrue==1) ways += (lT*rF) + (lF*rT);
                else ways += (lF*rF)+ (lT*rT);
            }
        }
        return ways;
    }

    // Memoization
    static int funct2(int i, int j, int isTrue, int[][][] dp, String exp){
        // Base Cases
        if(i>j) return 0; //1st base case isnt necessary I guess because 2nd base case already handles the smallest possible substring
        if(i==j){
            if(isTrue==1) return exp.charAt(i)=='T'?1:0;
            else return exp.charAt(i)=='F'?1:0;
        }
        if(dp[i][j][isTrue]!=-1)
            return dp[i][j][isTrue];

        int ways=0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            int lT = funct2(i, ind-1, 1, dp, exp);
            int lF = funct2(i, ind-1, 0, dp, exp);
            int rT = funct2(ind+1, j, 1, dp, exp);
            int rF = funct2(ind+1, j, 0, dp, exp);

            if(exp.charAt(ind)=='&'){
                if(isTrue==1) ways += lT*rT;
                else ways += (lT*rF) + (lF*rT) + (lF*rF);
            }
            else if(exp.charAt(ind)=='|'){
                if(isTrue==1) ways += (lT*rF) + (lF*rT) + (lT*rT);
                else ways += (lF*rF);
            }
            else{
                if(isTrue==1) ways += (lT*rF) + (lF*rT);
                else ways += (lF*rF)+ (lT*rT);
            }
        }
        return dp[i][j][isTrue]=ways;
    }

    // Tabulation
    static int funct3(int[][][] dp, String exp, int n){
        // Base Cases
        for(int i=0;i<n;i++){
            dp[i][i][0] = exp.charAt(i)=='F'?1:0;
            dp[i][i][1] = exp.charAt(i)=='T'?1:0;
        }
    
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=n-1;j++){
                if(i==j) continue;//avoid recomputing base cases
                for(int isTrue=0;isTrue<=1;isTrue++){
                    int ways=0;
                    for(int ind=i+1;ind<=j-1;ind+=2){
                        int lT = dp[i][ind-1][1];
                        int lF = dp[i][ind-1][0];
                        int rT = dp[ind+1][j][1];
                        int rF = dp[ind+1][j][0];

                        if(exp.charAt(ind)=='&'){
                            if(isTrue==1) ways += lT*rT;
                            else ways += (lT*rF) + (lF*rT) + (lF*rF);
                        }
                        else if(exp.charAt(ind)=='|'){
                            if(isTrue==1) ways += (lT*rF) + (lF*rT) + (lT*rT);
                            else ways += (lF*rF);
                        }
                        else{
                            if(isTrue==1) ways += (lT*rF) + (lF*rT);
                            else ways += (lF*rF)+ (lT*rT);
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

        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        }
        System.out.println(funct2(0,n-1,1,dp,exp));

        dp = new int[n][n][2];
        System.out.println(funct3(dp,exp, n));

    }
}