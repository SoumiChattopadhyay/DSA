// import java.util.Scanner;
public class Prog2 {
    public static void main(String[] args) {
        // pattern1(6);
        // pattern2(1);
        // pattern3(4);
        // pattern4(4);
        pattern5(4);
    }
//    * 
//   * * 
//  * * * 
// * * * * 
//* * * * * 
// * * * * 
//  * * * 
//   * *
//    *
    public static void pattern1(int n){
       for(int row=1;row<=2*n-1;row++){
            int totalSpacesinRow=(row<=n)?(n-row):row-n;
            int totalStarsinRow=(row<=n)?row:(2*n-row);
                for(int spaces=1;spaces<=totalSpacesinRow;spaces++){
                    System.out.print(" ");
                }
                for(int stars=1;stars<=totalStarsinRow;stars++){
                    System.out.print("* ");
                }
                System.out.println();
        }
    }
//        1 
//      2 1 2 
//    3 2 1 2 3 
//  4 3 2 1 2 3 4 
//5 4 3 2 1 2 3 4 5 
    public static void pattern2(int n){
        for(int row=1;row<=n;row++){
            for(int spaces=1;spaces<=n-row;spaces++){
                System.out.print("  ");
            }
            for(int nums=row;nums>=1;nums--){
                System.out.print(nums+" ");
            }
                for(int nums2=2;nums2<=row;nums2++){// if n=1,then row=1,row<=n and nums2=2 which is not <=1 so this loop never executed
                    System.out.print(nums2+" ");
                }
           System.out.println();
        }
    }
//   1
//  212
// 32123
//4321234
// 32123
//  212
//   1
    public static void pattern3(int n){
        for(int row=1;row<=2*n-1;row++){
        // c is the first starting num at any row
        int c=(row<=n)?(row):(2*n-row);
            for(int spaces=n-1;spaces>=c;spaces--){
                System.out.print(" ");
            }
            for(int nums=c;nums>=1;nums--){
                System.out.print(nums);
            }
            for(int nums2=2;nums2<=c;nums2++){
                System.out.print(nums2);
            }
           System.out.println();
        }
    }
    public static void pattern4(int n){
        n=2*n-1;
        for(int row=1;row<=n;row++){
            for(int col=1;col<=n;col++){
                int top=row,bottom=n-row+1,left=col,right=n-col+1;
                int val=Math.min(Math.min(Math.min(left,right),top),bottom);
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n){
        int originalN=n;
        n=2*n-1;
        for(int row=1;row<=n;row++){
            for(int col=1;col<=n;col++){
                int top=row,bottom=n-row+1,left=col,right=n-col+1;
                int val=originalN+1-Math.min(Math.min(Math.min(left,right),top),bottom);
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}

