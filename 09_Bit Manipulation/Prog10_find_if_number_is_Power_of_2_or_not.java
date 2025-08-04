public class Prog10_find_if_number_is_Power_of_2_or_not {//using bitwise operators
    public static boolean find(int n){
        // if 1 is present only once in its binary form
        int count=0;
        for(int i=n;i>0;i>>=1){ //TC=O(logN)
            if((i&1)==1){
                count++;
            }
        }
        if(count==1) 
            return true;
        else 
            return false;
    }
    // way2
    public static boolean find2(int n){
        if(n==0 || n<0) //Negative numbers are never powers of 2.Even if you think of negative exponents (like 2^-1=1/2),you get fractions, not negative numbers.
            return false;
        if((n&(n-1))==0)
            return true;
        else 
            return false;
    }
    public static void main(String[] args) {
        System.out.println(find(32));
        System.out.println(find(36));
        System.out.println(find2(32));
        System.out.println(find2(36));
        System.out.println(32&(32-1));//0
        System.out.println(32&31);//0
        System.out.println(36&35);//not 0
    }
}
