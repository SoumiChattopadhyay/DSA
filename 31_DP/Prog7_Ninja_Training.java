// https://www.geeksforgeeks.org/problems/geeks-training/1
public class Prog7_Ninja_Training {
    // Recursion
    static int funct(int day,int last, int[][] points){
        if(day==0){
            int maxi=0;
            for(int task=0;task<=2;task++){
                if(task!=last){
                    maxi=Math.max(maxi,points[0][task]);
                }
            }
            return maxi;
        }
        int maxi=0,point=0;
        for(int task=0;task<=2;task++){
            if(task!=last){
                point = points[day][task] + funct(day-1,task,points);
            }
            maxi = Math.max(point,maxi);
        }
        return maxi;
    }
    // Memoization
    static int funct2(int day,int last, int[][] points, int[][] dp){
        // Base case
        if(day==0){
            int maxi=0;
            for(int task=0;task<=2;task++){
                if(task!=last){
                    maxi=Math.max(maxi,points[0][task]);
                }
            }
            return maxi;
        }
        // Edge case
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        int maxi=0,point=0;
        for(int task=0;task<=2;task++){
            if(task!=last){
                point = points[day][task] + funct2(day-1,task,points,dp);
            }
            maxi = Math.max(point,maxi);
        }
        return dp[day][last]=maxi;
    }
    // Tabulation
    static int funct3(int d, int[][] points, int[][] dp){
        // Base Cases
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        int point=0;
        for(int day=1;day<=d;day++){
            for(int last=0;last<=3;last++){
                for(int task=0;task<=2;task++){
                    if(task!=last){
                        point=points[day][task]+dp[day-1][task];
                        dp[day][last]=Math.max(point,dp[day][last]);
                    }
                }
            }
        }
        return dp[d][3];
    }
    // Space Optimization
    static int funct4(int d, int[][] points){
        int[] dp = new int[4];
        // Base Cases
        dp[0] = Math.max(points[0][1],points[0][2]);
        dp[1] = Math.max(points[0][0],points[0][2]);
        dp[2] = Math.max(points[0][0],points[0][1]);
        dp[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        int point=0;
        int temp[];//dummy array for storing curr day
        for(int day=1;day<=d;day++){
            temp=new int[4];
            for(int last=0;last<=3;last++){
                for(int task=0;task<=2;task++){
                    if(task!=last){
                        point=points[day][task]+dp[task];
                        temp[last]=Math.max(point,temp[last]);
                    }
                }
            }
            dp=temp;
        }
        return dp[3];
    }
    static int ninjaTraining(int n, int[][] points){
        // return funct(n-1,3,points);
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }
        // return funct2(n-1,3,points,dp);
        // return funct3(n-1,points,dp);
        return funct4(n-1,points);
    }
    public static void main(String[] args) {
        int[][] points = {
            {2,1,3},
            {3,4,6},
            {10,1,6},
            {8,3,7}
        };
        System.out.println(ninjaTraining(4, points));
    }
}
