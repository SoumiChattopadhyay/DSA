public class Prog4_get_Rightmost_Set_Bit {
    public static int getRightMostSetBit(int n){
        return (int)log2(n&(-n))+1;
    }
    public static double log2(double x){
        return Math.log(x)/Math.log(2);
    }
    public static void main(String[] args) {
        System.out.println(getRightMostSetBit(101101100));//3
    }
}
