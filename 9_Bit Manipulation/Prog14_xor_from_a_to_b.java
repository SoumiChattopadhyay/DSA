public class Prog14_xor_from_a_to_b {
    public static int rangeXOR(int a, int b){
     // only for check, will give TLE(Time Limit Exceed) for large numbers
     int ans2 = 0;
     for (int i=a;i<=b;i++){
        ans2^=i;
     }
     System.out.println(ans2);

     return zeroToNumberXOR(b)^zeroToNumberXOR(a-1);
 }

 // this gives xor from 0 to a
    public static int zeroToNumberXOR(int a){
        return (a%4==0)?a:(a%4==1)?1:(a%4==2)?a+1:0; //TC=O(1), SC=O(1)
    }
    public static void main(String[] args) {
        System.out.println(rangeXOR(3, 9));
    }
}
