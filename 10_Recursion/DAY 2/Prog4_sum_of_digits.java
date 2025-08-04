public class Prog4_sum_of_digits{
    //TC: O(log n) because we are dividing the number by 10 in each recursive call and the number of digits in n is log(n) and we are doing O(1) work in each call. Each call does constant work: (n % 10) → getting the last digit.
    // Here log has base 10 because n is a decimal number. log(n) gives the number of digits in n because log(n) = log(10^k) = k, where k is the number of digits in n.
    // floor(log₁₀(n)) + 1 = floor(log₁₀(3456)) + 1. = 3+1 = 4, so the number of digits in 3456 is 4.
    //SC: O(log n) because of the recursion stack space. 
    public static void main(String[] args) {
        System.out.println(findSum(3456));
    }
    public static int findSum(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+findSum(n/10);
    }
}