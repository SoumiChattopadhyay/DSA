public class Prog09_Binary_Subarrays_with_Sum_Equal_To_Goal {
    // Optimal
    static int funct3(int[] arr, int goal){
        return funct(arr, goal)-funct(arr, goal-1);
    }
    // Counts no. of binary subarrays with sum<=goal
    static int funct(int[] arr, int goal){
        if(goal<0) return 0;
        int n = arr.length;
        int l=0,r=0,sum=0,cnt=0;
        while(r<n){
            sum+=arr[r];
            while(sum>goal){
                sum-=arr[l];
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,0};
        int goal=2;
        System.out.println(funct3(arr, goal));
    }
}
