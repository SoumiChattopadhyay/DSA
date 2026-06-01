public class Prog30_Spiral_Matrix {
    public static void spiral(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        int startRow= 0;
        int startCol= 0;
        int endCol= m-1;
        int endRow= n-1;
        // Optimal
        while(startRow<=endRow && startCol<=endCol){
            //top border
            for(int j=startCol;j<=endCol;j++){
                System.out.print(matrix[startRow][j]+" ");
            }
            //right border
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }
            //bottom border
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow==endRow){//avoids duplicate printing in edge case 1 - coz then top border j loop already executes once and prints all els so this loop just prints duplicates
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            //left border
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){//avoids duplicate printing in edge case 2 - coz then right border i loop already executes once and prints all els so this loop just prints duplicates
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
            }
    }
    public static void main(String[] args) {
        int matrix[][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}};
        spiral(matrix);
        System.out.println();

        matrix=new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}};
        spiral(matrix);
        System.out.println();

        //Edge Case 1 : when startRow=endRow
        matrix=new int[][]{
            {1,2,3}
            };
        spiral(matrix);
        System.out.println();

        // Edge Case 2 : when startCol=endCol
        matrix=new int[][]{
                {1},
                {2},
                {3}
            };
        spiral(matrix);
    }
}