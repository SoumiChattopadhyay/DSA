public class Prog57_Count_Square_Submatrices_with_All_Ones {
    // Optimal Solution (Tabulation)
    static int funct2(int[][] matrix){
        int n=matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) dp[i][0]=matrix[i][0]; 
        for(int j=0;j<m;j++) dp[0][j]=matrix[0][j];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0) dp[i][j]=0;
                else dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
            }
        } 
        int sum=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                sum+=dp[i][j];
                
        return sum;
    }
    // Brute Force 
    static int funct1(int[][] matrix){
        int n=matrix.length;
        int m = matrix[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    int maxSize = Math.min(n-i,m-j);
                    for(int size=1;size<=maxSize;size++){
                        boolean allOnes = true;
                        for(int x=i;x<i+size;x++){
                            for(int y=j;y<j+size;y++){
                                if(matrix[x][y]==0){
                                    allOnes=false;
                                    break;
                                }
                            }
                            if(!allOnes) break;
                        }
                        if(allOnes) count++;
                        else break;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        };
        System.out.println(funct1(matrix));
        System.out.println(funct2(matrix));
        matrix = new int[][]{
            {1,1,1},
            {1,1,1},
            {1,1,1}
        };
        System.out.println(funct1(matrix));
        System.out.println(funct2(matrix));
    }
}
