public class Prog9_Kadanes_algo {
    public static void main(String[] args) {
        int currSum=0,maxSum=Integer.MIN_VALUE,count=0;
        int ar[]={-2,-3,4,-1,-2,1,5,-3};
        for(int i=0;i<ar.length;i++){
            currSum+=ar[i];
            if(currSum<0){
                currSum=0;
            }  
            maxSum=Math.max(currSum,maxSum);
        }
        System.out.println("Maximum subarray sum is:"+maxSum);

        //Special case: if all elements are negative
        int arr[]={-2,-3,-4,-1,-2,-1,-5,-3};
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0)
                count++;
        }
        if(count==arr.length){
            int max=arr[0];
            for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        System.out.println("Maximum subarray sum is:"+max);
        }
        
    }
}
