public class Prog5_prod_of_digits {
    public static void main(String[] args) {
        System.out.println(findProduct(3456));
        System.out.println(findProduct(303));//0
    }
    public static int findProduct(int n){
        if(n%10==n){
            return n;
        }
        // if(n==0){
        //     return 1; //we return 1 because we are multiplying the digits, so multiplying by 0 will give 0.
        // }
        return (n%10)*findProduct(n/10); // multiply the last digit with the product of the remaining digits.
    }
}
