public class Prog2_Maximum_Points_You_Can_Obtain_From_K_Cards {
    static int funct1(int[] arr, int K){
        int n=arr.length;
        int lsum=0,rsum=0,maxSum=0;
        for(int i=0;i<K;i++) lsum+=arr[i];
        maxSum=lsum;
        int rightIndex=n-1;
        for(int i=K-1;i>=0;i--){
            lsum = lsum - arr[i];
            rsum = rsum + arr[rightIndex];
            maxSum = Math.max(maxSum,lsum+rsum);
            rightIndex--;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {6,2,3,4,7,2,1,7,1};
        int K=4;
        System.out.println(funct1(arr, K));
    }
}
