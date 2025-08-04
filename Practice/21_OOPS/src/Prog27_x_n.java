//TC: O(log n)
public class Prog27_x_n {
    public static int Power(int x, int n){
        if(n==0)
           return 1;
    
        int halfpower = Power(x,n/2);
        int halfpowersquare = halfpower*halfpower;

            if(n%2!=0)
               return x*halfpowersquare;
            else
               return halfpowersquare;  
    }
    public static void main(String args[]){
        int x=2, n=4;
        System.out.println(Power(x,n));
    }
}

// //TC:O(n) if n is huge then TC is huge 
// public class Prog27_x_n {
//     public static int expo(int x, int n){
//         if(n==0){
//             return 1;
//         }
//         else{
//             return x*expo(x,n-1);
//         }
//     }
//     public static void main(String args[]){
//         int x=4, n=5;
//         System.out.println(expo(x,n));
//     }
// }
