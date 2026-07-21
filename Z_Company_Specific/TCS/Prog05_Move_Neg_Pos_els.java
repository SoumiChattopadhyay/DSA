//Move all negative numbers to beginning and positive to end with constant extra space
//Note:
// Given array does not contain any zeroes.
// Order of resultant array does not matter.

import java.util.Arrays;

public class Prog05_Move_Neg_Pos_els {
    // Optimal Approach - Two Pointer Method
    // O(n) time and O(1) space
    static int[] funct1(int[] arr){
        int n=arr.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {-1,2,-3,4,-5};
        System.out.println(Arrays.toString(funct1(arr)));
    }
}

/*
How it works:
i scans every element.
j tells where the next negative number should go.
Initially
i=0,j=0 [-1,2,-3,4,-5]
arr[i] i.e. -1 is negative, So - 
    - Swap it with j (same position)
    - Do j++ --> j=1
i=1, j=1  [-1,2,-3,4,-5]
arr[i] i.e. 2 is positive, So do nothing
i=2,j=1 [-1,2,-3,4,-5]
arr[i] i.e. -3 is negative, So - 
    - Swap it with j  [-1,-3,2,4,-5]
    - Do j++ --> j=2
*/