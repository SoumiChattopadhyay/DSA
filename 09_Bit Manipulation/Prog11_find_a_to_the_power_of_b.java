public class Prog11_find_a_to_the_power_of_b {//using bitwise operators
    public static int find(int base,int power){
        // int ans=1;
        // while(power>0){ //TC=O(power)
        //     ans=ans*base;
        //     power--;
        // }
        // ans*=(int)Math.pow(base,power); //TC=O(1)
        int ans=1;
        while(power>0){
            if((power&1)==1){
                ans*=base;
            }
            base*=base;//squaring base
            power>>=1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(find(3,6));
    }
}
