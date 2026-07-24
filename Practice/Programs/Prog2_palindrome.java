import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        int rev=0,dig,i;
        for(i=x;i>0;i/=10){
            dig=i%10;
            rev=rev*10+dig;
        }
        if(rev==x)
        return true;
        else
        return false;
    }
    public void main(String args[]){
        boolean b;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        b = isPalindrome(x);
        if(b==true)
        System.out.println("true");
        else
        System.out.println("false");
        sc.close();
    }        
}