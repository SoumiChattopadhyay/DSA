public class Prog24_print_nth_Fibo {
    public static int print_nth_Fibo(int n){
        if(n==0 || n==1)
            return n;
        else{
            int fnm1 = print_nth_Fibo(n-1);
            int fnm2 = print_nth_Fibo(n-2);
            
            return fnm1+fnm2;
        }
                
    }
    public static void main(String[] args) {
        System.out.println(print_nth_Fibo(23));
}
}
