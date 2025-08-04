public class Prog7_Reverse {
    public static void main(String[] args) {
        // printReverse(345);
        System.out.println(findReverse(345));
    }
    
    public static int findReverse(int n){
        if(n==n%10){
            return n;
        }
        int lastDig=n%10;
        int digCount =(int)Math.floor(Math.log10(n))+1;
        System.out.println(digCount);
        return ((lastDig)*(int)Math.pow(10,digCount-1))+findReverse(n/10);
    }
    static int rev=0;
    public static void findReverse2(int n) {
        if (n == 0) {
            return;
        }
        int lastDig=n % 10;
        rev = rev*10+lastDig;
        findReverse2(n/10);
    }
    public static void printReverse(int n){
        if(n==0){
            return;
        }
        System.out.print(n%10);
        printReverse(n/10);
    }
}
