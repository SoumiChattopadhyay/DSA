public class Prog22_Recursion_Factorial {
    public static int printFact(int n) {
        if(n==0){
            return 1;
        }
        else{
            return n*printFact(n-1);
        }

    }
    public static void main(String[] args) {
        System.out.println(printFact(6));
    }
}
