/*
Given a positive integer n, find the square root of n. If n is not a perfect square, then 
return the floor value.
Floor value of any number is the greatest Integer which is less than or equal to that number.
*/
public class Prog14_Sqrt_of_a_No {
    static int findSqrt(int n){
        
        if(n==0 || n==1) return n;
        
        int low=1, high=n/2, ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid*mid<=n){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int n=8;
        System.out.println(findSqrt(n));
    }
}