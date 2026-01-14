public class Prog13_Minimum_Falling_Path_Sum {
    static int minFallingPathSum(int[][] a) {
        int n=a.length;
        int m=a[0].length;
         // Base Case
        int[] prevRow = new int[m];
        for(int j=0;j<m;j++){
            prevRow[j]=a[0][j];
        }
        for(int i=1;i<n;i++){
            int[] currRow = new int[m];
            for(int j=0;j<m;j++){
                int up=Integer.MAX_VALUE,leftDiag=Integer.MAX_VALUE,rightDiag=Integer.MAX_VALUE;
                if(j>0)
                    leftDiag = a[i][j]+prevRow[j-1];
                up = a[i][j]+prevRow[j];
                if(j<m-1)
                    rightDiag = a[i][j]+prevRow[j+1];
                currRow[j]=Math.min(up,Math.min(leftDiag,rightDiag));
            }
            prevRow=currRow;
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min=Math.min(min,prevRow[j]);
        }
        return min;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {2,1,3},
            {6,5,4},
            {7,8,9}
        };
        System.out.println(minFallingPathSum(matrix));
    }
}
