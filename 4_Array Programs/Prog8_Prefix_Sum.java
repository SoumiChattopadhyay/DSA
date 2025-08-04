//Maximum Subarray Sum(Prefix Sum Method)
public class Prog8_Prefix_Sum {
    public static void main(String[] args) {
        int i,j,maxSum=Integer.MIN_VALUE,sum=0;
        int ar[]={2,4,6,8,10};
        int prefix[]=new int[ar.length];//2 6 12 20 30
        prefix[0]=ar[0];
        //calculating the prefix sum array
        for(i=1;i<prefix.length;i++)
            prefix[i]=prefix[i-1]+ar[i];
        //finding the maximum subarray sum
        for(i=0;i<ar.length;i++){
            int start=i;
            for(j=i;j<ar.length;j++){
                int end=j;
                sum =(i==0)?prefix[end]:prefix[end]-prefix[start-1];
                if(sum>maxSum)
                    maxSum=sum;
            }
        }
        System.out.println("Maximum subarray sum="+maxSum);
    }
}