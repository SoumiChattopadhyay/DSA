public class Prog2_Spiral_Matrix {
    public static void spiral(int[][] matrix){
        int startRow=0;
        int startCol=0;
        int endCol=matrix[0].length-1;
        int endRow=matrix.length-1;
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
                if(startRow==endRow){//avoids duplicate printing in edge case
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }
            //left border
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){//avoids duplicate printing in edge case
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

        //Edge Case when startRow=endRow
        // int matrix[][]={
        //     {1,2,3}
        //     };
        // Edge Case when startCol=endCol
        // int matrix[][]={
        //         {1},{2},{3}
        //     };
        spiral(matrix);
    }
}