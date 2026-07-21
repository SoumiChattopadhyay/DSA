public class Prog13_Replace_All_0s_with_1s_in_a_No {
    static int funct(int n){
        
        if(n==0) return 1;
        
        int reversed=0;
        while(n>0){
            int digit=n%10;
            if(digit==0) digit=1;
            reversed=reversed*10+digit;
            n/=10;
        }
        
        int result=0;
        while(reversed>0){
            result=result*10+(reversed%10);
            reversed/=10;
        }

        return result;
    }
    public static void main(String[] args) {
        int n=204;
        System.out.println(funct(n));
    }
}
/*
Algorithm:
We extract each digit from the number by repeatedly taking the remainder when divided by 10. If the digit is 0, we change it to 1. We then rebuild the number in reverse and reverse it again to get the final result.
*/