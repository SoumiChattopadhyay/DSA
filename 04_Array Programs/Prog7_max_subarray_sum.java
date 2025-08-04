//Maximum Subarray(Brute's Force)
//Time complexity:O(n^3)
public class Prog7_max_subarray_sum {
    public static void main(String[] args) {
        int i,j,k,maxSum=Integer.MIN_VALUE,sum=0;
        int ar[]={1,-2,6,-1,3};
        for(i=0;i<ar.length;i++){
            for(j=i;j<ar.length;j++){
                sum=0;
                for(k=i;k<=j;k++){
                    sum=sum+ar[k];
                }
                System.out.println("Subarray sum ="+sum);
                if(sum>maxSum)
                    maxSum=sum;
            }
        }
        System.out.println("Maximum subarray sum="+maxSum);
    }
}
