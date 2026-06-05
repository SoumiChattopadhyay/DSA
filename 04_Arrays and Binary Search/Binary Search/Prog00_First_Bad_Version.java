public class Prog00_First_Bad_Version {
    public static int firstBadVersion(int n) {
        int low=1,high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isBadVersion(mid)){
                high=mid-1;//look for better ans(what if there are more previous bad products)
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    // Not the real logic, real logic is hidden in leetcode
    static boolean isBadVersion(int a){
        if(a%2==0) return false;
        else return true;
    }
    public static void main(String[] args) {
        System.out.println(firstBadVersion(6));
    }
}