public class Prog12_no_of_set_bits {
    public static int find(int n){
        int count=0;
        while(n>0){//TC=O(no.of bits in binary rep. of n) = O(roughly log2(n)) = O(log n), SC=O(1)
            int lastDig = n & 1;
            if(lastDig==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(find(9));
    }
}
