public class Prog3_prime_nos_in_a_range_optimised{
    //Sieve of Eratosthenes algorithm, //SC=O(n),TC=O()
    public static void printPrimesUpTo(int num){
        if(num<2){
            return;
        }
        boolean[] isComposite=new boolean[num+1];//by default all els are false
        for(int n=2;n<=num;n++){
            if(!isComposite[n]){
                for(int i=n*n;i<=num;i+=n){
                    isComposite[i]=true;
                }
                System.out.print(n+" ");
            }
        }
    }
    public static void main(String[] args) {
        // find all prime no.s b/w 1 to 40
        System.out.printf("All the prime no.s b/w 1 and %d are:\n",40);
        printPrimesUpTo(40);
    }
}