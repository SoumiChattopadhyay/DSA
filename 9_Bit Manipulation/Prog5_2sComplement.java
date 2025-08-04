public class Prog5_2sComplement {
    public static int find2sComplement(int n){
        return ~n + 1;
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println(n=find2sComplement(n));// whenever using bitwise operators input and out is in decimal form and all the binary things happen internally
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(find2sComplement(10)));// converting the result back to binary string for display
    }
}
