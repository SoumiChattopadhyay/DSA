public class Prog9_Pascals_Triangle {
    public static int find_sum_of_nth_row(int n){//using bitwise operators
        // return (int)Math.pow(2,n-1);
        return 1<<(n-1);
    }
    public static void main(String[] args) {
        System.out.println(find_sum_of_nth_row(6));//2^5=32
    }
}
