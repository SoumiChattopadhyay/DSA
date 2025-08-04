public class Prog8_No_of_digits_of_number_n_in_base_b_representation{
    public static int find(int n,int b){
        return (int)(Math.log(n)/Math.log(b))+1;
    }
    public static void main(String[] args) {
        System.out.println(find(5,2));//00000101 No.of digits=3
    }
}