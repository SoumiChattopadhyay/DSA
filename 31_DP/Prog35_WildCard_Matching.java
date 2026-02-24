public class Prog35_WildCard_Matching {
    // Recursion
    static boolean funct1(int i, int j,String s1, String s2){
        // Base Cases
        if(i<0 && j<0) return true;//if both s1 and s2 got exhausted(comparison successful)
        if(i<0 && j>=0) return false;//if s1 got exhauseted but s2 remains
        if(j<0 && i>=0){//if s2 got exhauseted but s1 remains
            for(int k=0;k<=i;k++){//then s2 can match with s1 only if s1 has all * s
                if(s1.charAt(k)!='*')
                    return false;
            }
            return true;
        }
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            return funct1(i-1, j-1, s1, s2);
        }

        if(s1.charAt(i)=='*'){
            return funct1(i-1,j,s1,s2) || funct1(i, j-1, s1, s2);//consider * as nothing or consider * as one more character
        }

        return false;
    }
    // Memoization
    static boolean funct2(int i, int j,int[][] dp,String s1, String s2){
        // Base Cases
        if(i<0 && j<0) return true;//if both s1 and s2 got exhausted(comparison successful)
        if(i<0 && j>=0) return false;//if s1 got exhauseted but s2 remains
        if(j<0 && i>=0){//if s2 got exhauseted but s1 remains
            for(int k=0;k<=i;k++){//then s2 can match with s1 only if s1 has all * s
                if(s1.charAt(k)!='*')
                    return false;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;

        boolean ans;
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            ans = funct2(i-1, j-1,dp, s1, s2);
        }
        else if(s1.charAt(i)=='*'){//write else if not if
            ans = funct2(i-1,j,dp,s1,s2) || funct2(i, j-1,dp, s1, s2);//consider * as nothing or consider * as one more character
        }
        else{
            ans=false;
        }
        dp[i][j]=ans?1:0;
        return ans;
    }
    // Memoization (1-based indexing in dp array - gives same solution)
    static boolean funct22(int i, int j,int[][] dp,String s1, String s2){
        // Base Cases
        if(i==0 && j==0) return true;//if both s1 and s2 got exhausted(comparison successful)
        if(i==0 && j>0) return false;//if s1 got exhauseted but s2 remains
        if(j==0 && i>0){//if s2 got exhauseted but s1 remains
            for(int k=1;k<=i;k++){//then s2 can match with s1 only if s1 has all * s
                if(s1.charAt(k-1)!='*')
                    return false;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;//if 1 returns true else returns false

        boolean ans;
        if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
            ans = funct22(i-1, j-1,dp, s1, s2);
        }
        else if(s1.charAt(i-1)=='*'){
            ans = funct22(i-1,j,dp,s1,s2) || funct22(i, j-1,dp, s1, s2);//consider * as nothing or consider * as one more character
        }
        else{
            ans=false;
        }
        dp[i][j]=ans?1:0;
        return ans;
    }
     // Tabulation (1-based indexing in dp array - to avoid negative indexing in dp array)
    static boolean funct3(int N, int M,boolean[][] dp,String s1, String s2){
        // Base Cases
        dp[0][0]=true;
        
        for(int j=1;j<=M;j++) 
            dp[0][j]=false;
        
        for(int i=1;i<=N;i++){
            boolean flag=true;
            for(int k=1;k<=i;k++){
                if(s1.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }                
            }
            dp[i][0]=flag;            
        }

    
       for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(s1.charAt(i-1)=='*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];//consider * as nothing or consider * as one more character
                else
                    dp[i][j]=false;
            }
        }

        return dp[N][M];
    }
    // Tabulation (1-based indexing in dp array - to avoid negative indexing in dp array)
    static boolean funct4(int N, int M,String s1, String s2){
        boolean[] prevRow = new boolean[M+1];
        boolean[] currRow = new boolean[M+1];

        // Base Cases
        prevRow[0]=true;
        
        for(int j=1;j<=M;j++) 
            prevRow[j]=false;
        
        
        for(int i=1;i<=N;i++){
            currRow = new boolean[M+1];

            boolean flag=true;
            for(int k=1;k<=i;k++){
                if(s1.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }                
            }
            currRow[0]=flag;

            for(int j=1;j<=M;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?')
                    currRow[j] = prevRow[j-1];
                else if(s1.charAt(i-1)=='*')
                    currRow[j] = prevRow[j] || currRow[j-1];//consider * as nothing or consider * as one more character
                else
                    currRow[j]=false;
            }

            prevRow=currRow;
        }

        return prevRow[M];
    }
    public static void main(String[] args) {
        String s1="ab*cd";
        String s2="abdefcd";
        int N=s1.length();
        int M=s2.length();
        System.out.println(funct1(N-1, M-1, s1, s2));

        int[][] dp = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct2(N-1, M-1, dp, s1, s2));


        dp = new int[N+1][M+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=M;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(funct22(N, M, dp, s1, s2));

        boolean[][] dp2 = new boolean[N+1][M+1];
        System.out.println(funct3(N, M, dp2, s1, s2));

        System.out.println(funct4(N, M, s1, s2));

    }
}
