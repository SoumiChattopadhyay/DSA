public class Prog22_Split_Array_Largest_Sum {//same as Painter's problem and Book Allocation problem
    static int splitArray(int[] arr, int k){
        int n=arr.length;
        if(k>n) return -1;
        int low=Integer.MIN_VALUE, high=0;
        for(int el:arr){
            low=Math.max(low,el);
            high+=el;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int cntSubarrays = count_Subarrays(arr, mid);
            if(cntSubarrays<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    static int count_Subarrays(int[] arr, int maxSum){
        int subarrays=1,subarraySum=0;
        for(int i=0;i<arr.length;i++){
            if(subarraySum+arr[i]<=maxSum){
                subarraySum+=arr[i];
            }
            else{
                subarrays++;
                subarraySum=arr[i];
            }
        }
        return subarrays;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int k=2;
        System.out.println(splitArray(arr, k));
    }
}
