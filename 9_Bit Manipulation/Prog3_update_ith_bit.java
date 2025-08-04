public class Prog3_update_ith_bit {
    public static int updateIthBit(int n, int i, int newBit){//either set or clear ith bit
        int bitMask=1<<i;
        if(newBit==1){
            return (n|bitMask);
        }else {
            return (n&(~bitMask));
        }
    }
    public static void main(String[] args) {
        System.out.println(updateIthBit(10, 2, 1));
    }
}
