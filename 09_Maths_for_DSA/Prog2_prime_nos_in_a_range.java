public class Prog2_prime_nos_in_a_range {
    public static void isPrime(int num){
        if(num<2){
            return;
        }
        for(int n=2;n<=num;n++){//TC=O(n√n)
            int c=2;
            boolean b=false;
            while(c*c<=n){
                if(n%c==0){
                    b=true;
                    break;
                }
                c++;
            }
            if(b==false){
                System.out.println(n);
            }
        }
    }
    public static void main(String[] args) {
        // find all prime no.s b/w 1 to 40
        System.out.printf("All the prime no.s b/w 1 and %d are:\n",40);
        isPrime(40);
    }
}
