public class Prog2_get_ith_bit {
    public static int get_ith_bit(int n,int i){
        return (n>>(i-1))&1;
    }
    public static int setIthBit(int n, int i){
        int bitMask=1<<(i-1);
        return (n|bitMask);
    }
    public static int clearIthBit(int n, int i){
        int bitMask=~(1<<(i-1));
        return (n&bitMask);
    }
    public static int updateIthBit(int n,int i,int newBit){
        n=clearIthBit(n, i); // making ith bit 0
        int bitMask=newBit<<i; //newbit is 0 or 1. We left shift it.
        return n|bitMask;//So ith bit is either 0|0=0 or 0|1=1
    }
    public static void main(String[] args) {
            System.out.println(get_ith_bit(9, 4));//get 3rd bit of 9(1001)
            System.out.println(setIthBit(10, 2));//set 3rd bit of 10(1010)
            System.out.println(clearIthBit(10, 1));//clear 2nd bit of 10 i.e. make it 0
            System.out.println(updateIthBit(10, 1,1));
    }

}







// public class Prog2_get_ith_bit {
//     public static int get_ith_bit(int n,int i){
//         if(((n>>i)&1)==0){
//             return 0;
//         }else{
//             return 1;
//         }
//     }
//     public static void main(String[] args) {
//             int num = get_ith_bit(9, 3);
//             System.out.println(num);
//     }

// }





// public class Prog2_get_ith_bit {
//     public static int get_ith_bit(int n,int i){
//             int k = (int)Math.pow(2,i);
//             if((n&k)==0){
//                 return 0;
//             }else{
//                 return 1;
//             }
//     }
//     public static void main(String[] args) {
//         int num = get_ith_bit(9, 3);
//         System.out.println(num);
//     }
// }
