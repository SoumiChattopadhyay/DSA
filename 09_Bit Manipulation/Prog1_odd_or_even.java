public class Prog1_odd_or_even{
    public static void checkOddOrEven(int n){
        int bitMask=1;
        if((n&bitMask) == 1){
            System.out.println("Odd Number.");
        }else{
            System.out.println("Even Number.");
        }
    }
    public static void main(String[] args) {
        checkOddOrEven(78);
    }
}