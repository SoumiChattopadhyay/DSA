public class Prog01_bitwise_Operators {
    public static void main(String[] args) {
        System.out.println(6&7);// 00000110 & 00000111 = 00000110 (6)
        System.out.println(6&0);// 00000110 & 00000000 = 00000000 (0) (num&0 gives 0)
        System.out.println(6&1);// 00000110 & 00000001 = 00000000 or 0 (num&1 gives last digit of num)

        System.out.println();
    }
}