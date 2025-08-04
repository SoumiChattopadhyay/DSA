public class Prog3_sum_of_1_to_n {
    public static void main(String[] args) {
        System.out.println(findSum(5));
    }
    public static int findSum(int n){
        if(n==0){
            return 0;
        }
        return n+findSum(n-1);
    }
}