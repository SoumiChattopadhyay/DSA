public class Prog4_N_Knights {
    public static void main(String[] args) {
        int n = 4;       // board size
        int k = 4;       // number of knights to place
        int[][] board=new int[n][n];
        int count=placeKnights(board,0,0,k);
        System.out.println("No. of possible arrangements="+count+"\n");
    }
    static int placeKnights(int[][]board,int row,int col,int knights){
        int count=0;
        // base case
        if(knights==0){
            //print the board array 
            displayBoard(board);
            return 1;
        }
        if(row==board.length){
            return 0;
        }
        if(col==board[0].length){
            return placeKnights(board, row+1, 0, knights);
        }
        // In Queens problem we were restricting placement of 2nd Queen on the same row
        // But here we can't do that. So removing the for loop for col and taking col as an argument and in the recursive call we are increasing col and not row.
        
        // placing the knight and checking for every row and col
        if(isSafe(board,row,col)){
            board[row][col]=1;
            count+=placeKnights(board,row,col+1,knights-1);
            board[row][col]=0;
        }
        // skipping the cell (this extra skipping line wasn't needed in queens part becoz there for loop was automatically handling the skipping part by moving on to the next iteration but here u have to make a separate recursive call if u dont place the knight)
        count+=placeKnights(board, row, col+1, knights);
        return count;
    }
    static boolean isSafe(int[][]board,int row,int col){
        if(isValid(row-2,col+1,board)){
            if(board[row-2][col+1]==1){// dont just right if(board[row-2][col-1]) because the value is 1 not boolean so you will see cant convert from int to boolean error
                return false;
            }
        }
        if(isValid(row-2,col-1,board)){
            if(board[row-2][col-1]==1){
                return false;
            }
        }
        if(isValid(row-1,col+2,board)){
            if(board[row-1][col+2]==1){
                return false;
            }
        }
        if(isValid(row-1,col-2,board)){
            if(board[row-1][col-2]==1){
                return false;
            }
        }
        return true;
    }
    static boolean isValid(int row,int col,int[][]board){
        if(row>=0 && row<board.length && col>=0 && col<board[0].length){
            return true;
        }
        return false;
    }
    static void displayBoard(int[][]board){
        for(int[] row:board){
            for(int element:row){
                if(element==1){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
}
}