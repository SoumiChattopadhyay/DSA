public class Prog5_Sudoku_Solver {
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','_','_','7','_','_','_','_'},
            {'6','_','_','1','9','5','_','_','_'},
            {'_','9','8','_','_','_','_','6','_'},
            {'8','_','_','_','6','_','_','_','3'},
            {'4','_','_','8','_','3','_','_','1'},
            {'7','_','_','_','2','_','_','_','6'},
            {'_','6','_','_','_','_','2','8','_'},
            {'_','_','_','4','1','9','_','_','5'},
            {'_','_','_','_','8','_','_','7','9'}
        };
        sudokuSolver(board);
    }
    static void sudokuSolver(char[][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='_'){
                    for(int k=1;k<=9;k++){
                        if(isSafe(board,k,i,j)){
                            board[i][j]=(char)(k+'0');
                            break;
                        }
                    }
                }
            }
        }
    }
    static boolean isSafe(char[][] board,int k,int row,int col){
        // check if same element is in the row or not
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]!='_' && board[row][j]-'0'==k){
                return false;
            }
        }
        // check if same element is in the col or not
        for(int i=0;i<board.length;i++){
            if(board[i][col]!='_' && board[i][col]==k){
                return false;
            }
        }
        // check if same element is present in the 3x3 sub-boxes of the grid(board) or not
       int rsi=row-row%3
       ,rei=rsi+2,
       csi=col-col%3,
       cei=csi+2;

        for(int i=rsi;i<=rei;i++){
            for(int j=csi;j<=cei;j++){
                if(board[i][j]!='_' && board[i][j]-'0'==k){
                    return false;
                }
            }
        }
        return true;
    }
}
