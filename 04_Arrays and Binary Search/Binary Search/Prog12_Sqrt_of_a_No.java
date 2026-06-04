public class Prog12_Sqrt_of_a_No {
    // Linear Search
    static int findSqrt(int n){
        int ans=0;
        for(int i=1;i<=n;i++){
            if((long)(i)*i<=n){
                ans=i;
            }
            else{
                break;
            }
        }
        return ans;
    }
    // Binary Search
    static int findSqrt_2(int n){
        if(n<2) return n;//for 1 and 0 while loop doesn't exist coz low>high
        int ans=0;
        int low=1,high=n/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((long)(mid)*mid<=n){
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
        System.out.println(findSqrt(36));
        System.out.println(findSqrt_2(36));
        System.out.println(findSqrt(28));//its sqrt is 5.292 so the floor will be 5
        System.out.println(findSqrt_2(28));//its sqrt is 5.292 so the floor will be 5
    }
}
