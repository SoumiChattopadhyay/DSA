public class Prog1_reverseNum{
    public static int reverse(int x) {
        int rev=0;
        while(x!=0){
            int dig=x%10;
            x/=10;
            if(rev>0 && rev>(Integer.MAX_VALUE-dig)/10 ||rev<0 && rev<(Integer.MIN_VALUE-dig)/10 ){
                return 0;
            }
            rev=rev*10+dig;
        }
        return rev;
    }
    public static void main(String[] args) {
        System.out.println( reverse(120));
    }
}