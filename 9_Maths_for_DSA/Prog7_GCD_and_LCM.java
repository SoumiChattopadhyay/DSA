public class Prog7_GCD_and_LCM {
    public static int findGCD(int a, int b){
            // WAY-1 : Iteration
        // while(b!=0){
        //     int temp=b;
        //     b=a%b;
        //     a=temp;
        // }
        // return a;

            // WAY-2 : Recursion
            if(b==0){
                return a;
            }
            return findGCD(b,a%b);
    }
    public static int findLCM(int a,int b){
        return (a*b)/findGCD(a, b);
    }
    public static void main(String[] args) {
        System.out.println(findGCD(36,24));
        System.out.println(findLCM(3,9));
    }
    //a=36,b=24
    //a=24,b=36%24=12
    //a=12,b=24%12=0
    //b=0 so a is gcd which is 12.
}
