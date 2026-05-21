public class Prog1_Longest_Subarray_with_Sum_Less_Than_Equal_To_K {
    // Brute
    static int funct1(int[] arr, int K){
        int n=arr.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+arr[j];
                if(sum<=K){
                    maxLen=Math.max(maxLen,j-i+1);
                }
                else if(sum>K) break;
            }
        }
        return maxLen;
    }
    // Better
    static int funct2(int[] arr, int K){
        int n=arr.length;
        int l=0,r=0,sum=0,maxLen=0;
        while(r<n){
            sum=sum+arr[r];
            while(sum>K){
                sum=sum-arr[l];
                l++;
            }
            if(sum<=K){
                maxLen=Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    // Optimal
    static int funct3(int[] arr, int K){
        int n=arr.length;
        int l=0,r=0,sum=0,maxLen=0;
        while(r<n){
            sum=sum+arr[r];
            if(sum>K){
                sum=sum-arr[l];
                l++;
            }
            if(sum<=K){
                maxLen=Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,1,7,10};
        int K=14;
        System.out.println(funct1(arr, K));
        System.out.println(funct2(arr, K));
        System.out.println(funct3(arr, K));
    }
}
