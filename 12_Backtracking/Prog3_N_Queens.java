public class Prog3_N_Queens {
    public static void main(String[] args) {
        int n=4;
        int[][] board=new int[n][n];
        int count=placeQueens(board,0);
        System.out.println("No. of possible arrangements="+count);;
    }
    static int placeQueens(int[][]board,int row){
        int count=0;
        // base case
        if(row==board.length){
            //print the board array 
            displayBoard(board);
            return 1;
        }
        for(int col=0;col<board[0].length;col++){
            // placing the queen and checking for every row and col
            if(isSafe(board,row,col)){
                board[row][col]=1;
                count+=placeQueens(board,row+1);
                board[row][col]=0;
            }
        }
        return count;
    }
    static boolean isSafe(int[][]board,int row,int col){
        // checking for that fixed column
        for(int i=row;i>=0;i--){
            if(board[i][col]==1){
                return false;
            }
        }
        //checking for upper left diagonal
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        //checking for upper right diagonal
        for(int i=row,j=col;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    static void displayBoard(int[][]board){
         for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
    }
}
