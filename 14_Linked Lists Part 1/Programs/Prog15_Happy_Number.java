// Input: n = 19 (Happy No.)

// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

// Input: n = 2
// 2^2=4
// 4^2=16
//...so we never get 1 as the sum of digits so not happy no.

// TLE - Time Limit Exceeded Exception might occur if we try to run a loop in this case coz the loop will run infinitely if we dont get 1
// So we will solve this using LinkedList
public class Prog15_Happy_Number{
    public static void main(String[] args) {
        System.out.println(12+" is"+(isHappy(12)?"":" not")+" a happy no.");
        System.out.println(19+" is"+(isHappy(19)?"":" not")+" a happy no.");
    }
    public static boolean isHappy(int n){
        int slow=n;
        int fast=n;
        // cycle detection
        do{//using do while so even if slow=fast at beginning loop still runs once and then their values are changed so loop doesnt stop it continues running
            slow=find_Square_of_Digits(slow);//+1
            fast=find_Square_of_Digits(find_Square_of_Digits(fast));//+2
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    public static int find_Square_of_Digits(int n){
        int dig;
        int sum=0;
        while(n!=0){
            dig=n%10;
            sum=sum+(dig*dig);
            n/=10;
        }
        return sum;
    }
}
