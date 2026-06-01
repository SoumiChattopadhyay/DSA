import java.util.Arrays;

public class Prog29_Rotate_Matrix_by_90_degrees {
    // Brute
    static int[][] funct1(int[][] matrix){
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        return ans;
    }

    // Optimal --> TC = O(N/2 * N/2) + O(N x N/2)
    static int[][] funct2(int[][] matrix){
        int n = matrix.length;

        // Do transpose of matrix --> TC = O(N/2 * N/2)
        for(int i=0;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){
                //swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse each row of matrix --> TC = O(N * N/2) 
        int p1=0, p2=n-1;
        for(int i=0;i<n;i++){
            while(p1<p2){//Uses 2 pointer approach and reverses a given array in O(N/2)
                int temp = matrix[i][p1];
                matrix[i][p1] = matrix[i][p2];
                matrix[i][p2] = temp;
                p1++;
                p2--;
            }
        }
        
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {//Given n x n array
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int[][] ans = funct1(matrix);
        for(int[] a:ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();

        
        matrix = new int[][]{//Given n x n array
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        ans = funct1(matrix);
        for(int[] a:ans){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
}
