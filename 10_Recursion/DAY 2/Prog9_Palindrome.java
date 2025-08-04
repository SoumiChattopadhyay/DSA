public class Prog9_Palindrome {
    public static void main(String[] args) {
        System.out.println(Palindrome(3457543));
        System.out.println(Palindrome(345743));
    }
    public static boolean Palindrome(int n){
        if(n==findReverse(n)){
            return true;
        }else{
            return false;
        }
    }
    public static int findReverse(int n){
        if(n==n%10){
            return n;
        }
        int lastDig=n%10;
        int digCount =(int)Math.floor(Math.log10(n))+1;
        return ((lastDig)*(int)Math.pow(10,digCount-1))+findReverse(n/10);
    }
   
}
