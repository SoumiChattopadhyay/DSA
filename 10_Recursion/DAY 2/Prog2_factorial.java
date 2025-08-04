public class Prog2_factorial{
    public static void main(String[] args) {
        // TC: O(n)
        // SC: O(n) (due to recursion stack space)
        System.out.println(factorial(6)); // 720
        System.out.println(factorial(0)); // 1
        System.out.println(factorial(1)); // 1
    }
    public static int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
}