public class Prog16_Smallest_Divisor_given_a_Threshold {
    static int find_Sum_of_Divisions(int[] arr, int divisor){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=(int)Math.ceil((double)arr[i]/divisor);
        }
        return sum;
    }
    // Brute
    static int funct1(int[] arr, int limit){
        int maxEl=arr[0];
        for(int num:arr) maxEl = Math.max(maxEl,num);
        for(int divisor=1;divisor<=maxEl;divisor++){
            if(find_Sum_of_Divisions(arr,divisor)<=limit){
                return divisor;
            }
        }
        return -1;
    }
    // Optimal
    static int funct2(int[] arr, int limit){
        int maxEl=arr[0];
        for(int num:arr) maxEl=Math.max(maxEl,num);
        int low=1,high=maxEl,ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(find_Sum_of_Divisions(arr,mid)<=limit){
                ans=mid;//store possible ans
                high=mid-1;//look for smaller divisors if possible
            }
            else{
                low=mid+1;//divisor must be larger
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int limit=8;
        System.out.println(funct1(arr, limit));
        System.out.println(funct2(arr, limit));
    }
}
