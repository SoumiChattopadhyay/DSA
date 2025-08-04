public class Prog8_countZeroes {
    public static void main(String[] args) {
        System.out.println(countZeroes(809400048));
        System.out.println(countZeroes(48));
    }
    static int countZeroes(int n){
        if(n==n%10){
            return (n==0)?1:0;
        }
        int lastDig=n%10;
        return ((lastDig==0)?1:0)+countZeroes(n/10);//the round brackets are imp for precision
    }
}
