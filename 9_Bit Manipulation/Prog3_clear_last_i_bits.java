public class Prog3_clear_last_i_bits {
    public static void clear(int n,int i){
        int bitmask=(~0)<<i;
        int ans=n&bitmask;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(ans));
    }
    public static void main(String[] args) {
        clear(10,2);
    }
}
