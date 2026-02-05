public class Prog25_Rod_Cutting {
    // Recursion
    static int funct1(int ind, int rodLength, int[] price){
        // Base Case
        if(ind==0){ 
            return (rodLength/(ind+1))*price[ind];
        }
        int nottake = 0 + funct1(ind-1, rodLength, price);
        int take = Integer.MIN_VALUE;
        if(ind+1<=rodLength){
            take = price[ind] + funct1(ind, rodLength-(ind+1), price);
        }
        return Math.max(take,nottake);
    }
    // Memoization
    static int funct2(int ind, int rodLength,int[][] dp, int[] price){
        // Base Case
        if(ind==0){ 
            return (rodLength/(ind+1))*price[ind];
        }
        if(dp[ind][rodLength]!=-1) return dp[ind][rodLength];

        int nottake = 0 + funct2(ind-1, rodLength, dp, price);
        int take = Integer.MIN_VALUE;
        if(ind+1<=rodLength){
            take = price[ind] + funct2(ind, rodLength-(ind+1), dp, price);
        }
        return dp[ind][rodLength] = Math.max(take,nottake);
    }
    // Tabulation
    static int funct3(int N, int rodLength,int[][] dp, int[] price){
        // Base Case
        for(int len=1;len<=rodLength;len++){
            dp[0][len] = len*price[0];
        }
        
        for(int ind=1;ind<N;ind++){
            for(int len=1;len<=rodLength;len++){
                int nottake = 0 + dp[ind-1][len];
                int take = Integer.MIN_VALUE;
                if(ind+1<=len){
                    take = price[ind] + dp[ind][len-(ind+1)];
                }
                dp[ind][len] = Math.max(take,nottake);
            }
        }
        
        return dp[N-1][rodLength];
    }
    // Space Optimization
    static int funct4(int N, int rodLength, int[] price){
        int[] prevRow = new int[rodLength+1];
        int[] currRow = new int[rodLength+1];
        
        // Base Case
        for(int len=1;len<=rodLength;len++){
            prevRow[len] = len*price[0];
        }
        
        for(int ind=1;ind<N;ind++){
            currRow = new int[rodLength+1];
            for(int len=1;len<=rodLength;len++){
                int nottake = 0 + prevRow[len];
                int take = Integer.MIN_VALUE;
                if(ind+1<=len){
                    take = price[ind] + currRow[len-(ind+1)];
                }
                currRow[len] = Math.max(take,nottake);
            }
            prevRow=currRow;
        }
        
        return prevRow[rodLength];
    }
    // 1-Row Space Optimization
    static int funct5(int N, int rodLength, int[] price){
        int[] prevRow = new int[rodLength+1];
        
        // Base Case
        for(int len=1;len<=rodLength;len++){
            prevRow[len] = len*price[0];
        }
        
        for(int ind=1;ind<N;ind++){
            for(int len=1;len<=rodLength;len++){
                int nottake = 0 + prevRow[len];
                int take = Integer.MIN_VALUE;
                if(ind+1<=len){
                    take = price[ind] + prevRow[len-(ind+1)];
                }
                prevRow[len] = Math.max(take,nottake);
            }
        }
        
        return prevRow[rodLength];
    }
    public static void main(String[] args) {
        int N = 5;
        int[] price = {2,5,7,8,10};
        System.out.println(funct1(N-1, N, price));

        int[][] dp = new int[N][N+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=N;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(N-1, N,dp, price));

        dp = new int[N][N+1];
        System.out.println(funct3(N, N,dp, price));
        System.out.println(funct4(N, N, price));
        System.out.println(funct5(N, N, price));
    }
}
