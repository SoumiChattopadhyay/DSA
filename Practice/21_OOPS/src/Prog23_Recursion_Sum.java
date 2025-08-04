public class Prog23_Recursion_Sum {
    public static int printSum(int n){
        if(n==1)
        return 1;
        else{
            return n+printSum(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(printSum(4));
    }
}
