// Mr. X plans to rob houses along a street.
// Houses are arranged in a circle, means first house is neighbor of last house.
// Meanwhile adjacent houses have a security system connected, and will automatically call the police if two adjacent houses were broken into on the same night.
// Given an array of positive integers denoting the amount of money in each house
// Return the maximum amount of money Mr. X can rob tonight without alerting the police

import java.util.Arrays;

public class Prog6_House_Robber {
    // Space Optimization
    static int rob(int[] arr,int idx){
        int prev2=0;
        int prev=arr[0];
        int curr=Integer.MIN_VALUE,pick=Integer.MIN_VALUE, notPick=Integer.MIN_VALUE;
        for(int i=1;i<=idx;i++){
            pick=arr[i];
            if(i>1) 
                pick+=prev2;
            notPick=0+prev;
            curr=Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] nums={2,7,9,3,1};
        int n=nums.length;
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        int k=-1;
        for(int i=0;i<n;i++){
            if(i!=0){
                k++;
                temp1[k]=nums[i];
            }
            if(i!=n-1)
                temp2[i]=nums[i];
        }
        System.out.println(Arrays.toString(temp1));
        System.out.println(Arrays.toString(temp2));
        System.out.println(Math.max(rob(temp1,n-2),rob(temp2,n-2)));
    }
}