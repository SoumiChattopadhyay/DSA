import java.util.ArrayList;
import java.util.List;

public class Prog11_Prime_Factors_of_a_No {
    // Optimal
    // TC:O(√n), SC:O(k) where k = number of unique prime factors
    static List<Integer> findPrimeFactors(int n){
        List<Integer> ans = new ArrayList<>();
        // Divide n by 2 till it becomes odd
        if(n%2==0){
            ans.add(2);
            while(n%2==0)
                n/=2;
        }
        // Check odd numbers from 3 to sqrt(n)
        for(int i=3;i*i<=n;i+=2){//Instead of writing i<=Math.sqrt(i) and calling the function Math.sqrt everytime we do i*i<=n. They mean the same thing.
            if(n%i==0){
                ans.add(i);
                while(n%i==0)
                    n/=i;
            }
        }
        // If the no. is greater than 1 and nobody divided it, then it's prime
        if(n>1)
            ans.add(n);

        return ans;
    }
    public static void main(String[] args) {
        int n=60;
        System.out.println(findPrimeFactors(n));
    }
}