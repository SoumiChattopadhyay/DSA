public class Prog21_Recursion_Basics {
   public static void PrintDec(int n){
    if(n==1){ //Base Case
        System.out.print(n);
        return;
    }
    else{
        System.out.print(n+" ");
        PrintDec(n-1);
    }
   }
   public static void PrintInc(int n){
    if(n==1){ //Base Case 
        System.out.print(n+" ");
        return;
    }
    else{
        PrintInc(n-1);
        System.out.print(n);
    }
   }
   public static void main(String[] args) {
    PrintDec(6);
    System.out.println();
    PrintInc(9);
   }
}




// public class Prog21recursion {
// public static void Print(int x){
//              // Base Case
//             if(x>0){
//             System.out.print(x+" ");
//             Print(--x);
//             }
//         }
//         public static void main(String[] args) {
//             Print(7);
//         }
// }