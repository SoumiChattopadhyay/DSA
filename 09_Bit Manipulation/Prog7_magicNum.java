public class Prog7_magicNum {
    public static int find_nth_Magic_Num(int n){
        // Way 1
        // n&1 gives last digit of n. Right shifting i everytime.
        int lastdig,count=1,sum=0;
        for(int i=n;i!=0;i>>=1){//(TC=O(logN))How many times the loop runs = no. of digits in binary rep. of n= (int)log2(n)+1
            lastdig=i&1;
            sum+=(int)Math.pow(5,count)*lastdig;
            count++;
        }
        return sum;

        // Way 2
        // Steps
        // 1.Convert n into binary form
        // int count=0,sum=0,dig;
        // for(int i=n;i!=0;i/=2){
        //     dig=i%2;
        //     sum+=(int)Math.pow(10,count)*dig;
        //     count++;
        // }
        // // 2.Convert this binary number into magic representation(i.e. power of 5 rep.)
        // n=sum;
        // sum=0;
        // count=1;
        // for(int i=n;i!=0;i/=10){
        //     dig=i%10;
        //     sum+=(int)Math.pow(5,count)*dig;
        //     count++;
        // }
        // return sum;
    }
    public static void main(String[] args) {
        System.out.println(find_nth_Magic_Num(6));
    }
}
// Find nth magic number.
// 1st magic num : 1(00000001) 5^1 = 5
// 2nd magic num : 2(00000010) 5^2 = 25
// 3rd magic num : 3(00000011) 5^2+5^1 = 25+5 = 30
// 4th magic num : 4(00000100) 5^3 = 125
// 5th magic num : 5(00000101) 5^3+5^1 = 125+5 = 130

// Steps
/* 1.Convert the no. n into binary
   2.Convert this binary number into magic representation(i.e. power of 5 rep.)
*/