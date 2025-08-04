import java.util.*;
public class Prog1{
    public static void main(String args[]){
        // pattern1(6);
        // pattern2(4);
        // pattern3(5);
        // pattern4(5);
        pattern5(6);
    }
    public static void pattern1(int n){
        int row,col;
        for(row=1;row<=n;row++){
            for(col=1;col<=row;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){
        int row,col;
        for(row=1;row<=n;row++){
            for(col=1;col<=n;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n){
        int row,col;
        for(row=1;row<=n;row++){
            for(col=1;col<=n-row+1;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){
        int row,col;
        for(row=1;row<=n;row++){
            for(col=1;col<=row;col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n){
        Scanner sc=new Scanner(System.in);
        while(n%2==0){
            System.out.println("Please enter an odd no.: ");
            n=sc.nextInt();
            
        }
        sc.close();
        for(int row=1;row<=2*n-1;row++){
            int totalColsinRow=(row<=n)?row:(2*n-row);
                for(int col=1;col<=totalColsinRow;col++){
                    System.out.print("* ");
                }
                System.out.println();
        }
    }
}