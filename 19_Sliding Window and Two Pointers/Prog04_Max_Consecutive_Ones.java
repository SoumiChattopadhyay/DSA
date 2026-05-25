public class Prog04_Max_Consecutive_Ones {// or Longest Subarray with k zeroes
    static int funct1(int[] arr, int k){
        int n=arr.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            int zeroes=0;
            for(int j=i;j<n;j++){
                if(arr[j]==0) zeroes++;
                if(zeroes<=k){
                    int len = j-i+1;
                    maxLen = Math.max(len,maxLen);
                }
                else{
                    break;
                } 
            }
        }
        return maxLen;
    }
    static int funct2(int[] arr, int k){
        int n=arr.length;
        int l=0,r=0,maxLen=0,zeroes=0;
        while(r<n){
            if(arr[r]==0) zeroes++;
            while(zeroes>k){
                if(arr[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k){
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
    static int funct3(int[] arr, int k){
        int n=arr.length;
        int l=0,r=0,maxLen=0,zeroes=0;
        while(r<n){
            if(arr[r]==0) zeroes++;
            if(zeroes>k){
                if(arr[l]==0) zeroes--;
                l++;
            }
            if(zeroes<=k){
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(funct1(arr, k));
        System.out.println(funct2(arr, k));
        System.out.println(funct3(arr, k));
    }
    
}
