public class Prog1_prime{
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        int i=2;
        while(i*i<=n){//TC=O(√n)
            if(n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(13);
        System.out.println(36);
    }
}