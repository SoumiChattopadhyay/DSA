public class Prog14_patterns{
    public static void main(String[] args) {
        // pattern1(4,1);
        pattern2(4,1);
    }
    public static void pattern1(int row,int col){
       if(row==0){
        return;
       }
       if(col<=row){
        System.out.print("* ");
        pattern1(row, col+1);
       }
       else{
        System.out.println();
        pattern1(row-1, 1);
       }
    }
// col   1 2 3 4
// row
//  4    * * * *
//  3    * * *
//  2    * *
//  1    *

//main calls--> p(row=4,col=1) -->  p(row=4,col=2) -->  p(row=4,col=3) -->  p(row=4,col=4) -->  p(row=4,col=5)
//              prints *            prints *            prints *            prints *            prints \n
// if(col<=row) then print *
// if col becomes > row then print new line and call p(row-1,1) for the next row and reinitialize col's value to 1
public static void pattern2(int row,int col){
       if(row==0){
        return;
       }
       if(col<=row){
        pattern2(row, col+1);
        System.out.print("* ");
       }
       else{
        pattern2(row-1, 1);
        System.out.println();
       }
    }
// col   1 2 3 4
// row
//  4    *
//  3    * *
//  2    * * *
//  1    * * * *
//main calls--> p(row=4,col=1) -->  p(row=4,col=2) -->  p(row=4,col=3) -->  p(row=4,col=4) -->  p(row=4,col=5)
//              prints *            prints *            prints *            prints *            prints \n
// if(col<=row) then print *
// if col becomes > row then print new line and call p(row-1,1) for the next row and reinitialize col's value to 1
}