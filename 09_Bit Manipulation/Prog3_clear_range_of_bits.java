public class Prog3_clear_range_of_bits {
    public static void clear(int n, int i, int j){
        int a=(~0)<<j;
        int b=(int)Math.pow(2,i-1)-1;
        int bitmask=a|b;
        int ans=n&bitmask;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(ans));
    }
    public static void main(String[] args) {
        clear(10,3,5);
    }
}
