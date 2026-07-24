import java.util.ArrayList;
import java.util.Arrays;

public class Prog34_Matrix {
    // Find maximum element of each row in a matrix
    static void funct1(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            int max=mat[i][0];
            for(int j=1;j<mat[0].length;j++){
                max=Math.max(max,mat[i][j]);
            }
            System.out.println("Maximum element in row "+i+" is: "+max);
        }
    }

    // Sort a Matrix
    static int[][] funct2(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int[] arr = new int[n*m];
        int k=0;
        // Store all elements in a 1D array
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[k++]=matrix[i][j];
            }
        }
        // Sort the array
        Arrays.sort(arr);
        // Fill the matrix back row by row.
        k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=arr[k++];
            }
        }
        return matrix;
    }
    // Multiply Matrices
    static int[][] funct3(int[][] a, int[][] b){
         int n = a.length;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return ans;
    }
    /*
    Take the ith row of matrix A.
    Take the jth column of matrix B.
    Multiply corresponding elements.
    Add them.
    */

    /*
    Rotate a Rectangular Image by 90 Degree Clockwise
    Given an image represented by m x n matrix, rotate the image by 90 degrees in clockwise 
    direction. Please note the dimensions of the result matrix are going to n x m for an m x n 
    input matrix.

    Input:      1   2   3   4
                5   6   7   8
                9  10  11  12
                13 14  15  16
    Output:     13   9   5   1
                14   10  6  2
                15   11   7  3
                16  12   8  4
    */
   static void funct4(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        int[][] ans = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][n-1-i]=mat[i][j];
            }
        }
        mat=ans;
   }
   /*
    Observe the pattern:

    Old position: (i,j)

    New row becomes: j

    New column becomes: n-1-i
    where n = number of rows
   
   */

    // Rotate Matrix Clockwise by One
    /*
    Given an n × m matrix mat[][], rotate all its elements by one position in clockwise, 
    layer by layer (each rectangular layer (ring)) of the matrix should be rotated independently, 
    return the modified matrix.
    */
    static int[][] funct5(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=m-1;

        while(top<bottom && left<right){

            ArrayList<Integer> list = new ArrayList<>();//New layer, new elements

            // Put top row in list
            for(int j=left;j<=right;j++){
                list.add(mat[top][j]);
            }
            // Put right col in list
            for(int i=top+1;i<=bottom;i++){
                list.add(mat[i][right]);
            }
            // Put bottom row in list
            for(int j=right-1;j>=left;j--){
                list.add(mat[bottom][j]);
            }
            // Put left col in list
            for(int i=bottom-1;i>=top+1;i--){//>top or >=top+1 
                list.add(mat[i][left]);
            }

            // Rotate clockwise by one
            list.add(0,list.remove(list.size()-1));//Replace 1st el with last el in list

            int k=0;

            // Fill top row back in matrix
            for(int j=left;j<=right;j++){
                mat[top][j]=list.get(k++);
            }
            // Fill right col back in matrix
            for(int i=top+1;i<=bottom;i++){
                mat[i][right]=list.get(k++);
            }
            // Fill bottom row back in matrix
            for(int j=right-1;j>=left;j--){
                mat[bottom][j]=list.get(k++);
            }
            // Fill left col back in matrix
            for(int i=bottom-1;i>=top+1;i--){//>top or >=top+1
                mat[i][left]=list.get(k++);
            }

            top++;
            bottom--;
            left++;
            right--;
        }
        return mat;
    }
    /*
    Easy Memory Trick

    For each layer:

    Take all boundary elements into a list.
    Rotate the list by one (last → first).
    Put the elements back in the same boundary order.
    Move inward and repeat.

    Complexity:

    Time: O(m × n)
    Space: O(1)
    */

   // Search a 2D matrix
   static boolean funct6(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target)
                return true;

            if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
   }
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 9, 5, 6 },
                { 7, 8, 4 }
        };
        funct1(mat);

        funct2(mat);
        for(int[] arr:mat){
            System.out.println(Arrays.toString(arr));
        }

        mat = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        funct5(mat);

        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
