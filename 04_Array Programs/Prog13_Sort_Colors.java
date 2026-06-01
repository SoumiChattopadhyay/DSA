/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Examples:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2] */

import java.util.Arrays;

public class Prog13_Sort_Colors {

    // Brute solution (Merge Sort) 
    // TC=O(NlogN), SC=O(N)
    static void sortColors1(int[] nums){
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(mid<=high){
            if(nums[mid]==0){
                //swap. Move 0 to left side by swapping mid ele with low ele
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                //swap. Move 2 to right side by swapping mid ele with high ele
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }

    // Better solution 
    // TC=O(N)+O(N), SC=O(1)
    static void sortColors2(int[] nums){
        
        // Keep 2 variables
        int cnt0=0, cnt1=0;
        
        // Do a single traversal of the array
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) cnt0++;//cnt0 stores no. of 0s in the array
            else if(nums[i]==1) cnt1++;//cnt1 stores no. of 1s in the array
        }// This loop takes O(N)

        // Run a loop from 0 to cnt0-1 and manually overwrite that many 0s into the array
        for(int i=0;i<cnt0;i++){
            nums[i]=0;
        }

         // Next Run a loop from cnt0 to cnt0+cnt1-1 and manually overwrite that many 1s into the array
        for(int i=cnt0;i<cnt0+cnt1;i++){
            nums[i]=1;
        }

         // Next Run a loop from cnt0+cnt1 to n-1 and manually overwrite that many 2s into the array
        for(int i=cnt0+cnt1;i<nums.length;i++){
            nums[i]=2;
        }
        // These 3 loops combined take O(N)
    }
    
    // Optimal Solution
    // Dutch National Flag Algorithm
    // TC=O(N), SC=O(1)
    static void sortColors3(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid<=high){ //whenever mid goes beyond high means the unsorted region has shrinked completely
            if(arr[mid]==0){
                // swap arr[mid] and arr[low] (Dont use 2 variable swapping method)
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;

                mid++;
                low++;
            }
            else if(arr[mid]==1) 
                mid++;
            else{
                // swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors1(nums);
        System.out.println(Arrays.toString(nums));
        
        nums = new int[]{2,0,2,1,1,0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2,0,2,1,1,0};
        sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
/*
You used addition-subtraction swap:
arr[mid]=arr[mid]+arr[low];
arr[low]=arr[mid]-arr[low];
arr[mid]=arr[mid]-arr[low];

This works but interviewers usually prefer a temporary variable swap because it is Safer (no overflow risk)

The addition-subtraction swap fails when both indices are the same.
This is a known drawback of this swap trick.
Correct Fix :Use a temporary variable swap instead.

Example: 
With input [2,2]

Initial state:

arr = [2,2]

low = 0
mid = 0
high = 1
Step 1

arr[mid] == 2

So you run:

arr[mid] = arr[mid] + arr[high];
arr[high] = arr[mid] - arr[high];
arr[mid] = arr[mid] - arr[high];

This swaps arr[0] with arr[1].

Array remains:

[2,2]

Then:

high--
high = 0
Step 2

Now:

low = 0
mid = 0
high = 0

Again arr[mid] == 2.

Now your swap tries to swap index 0 with index 0.

Let's compute:

arr[0] = arr[0] + arr[0] = 2 + 2 = 4
arr[0] = arr[0] - arr[0] = 4 - 4 = 0
arr[0] = arr[0] - arr[0] = 0 - 0 = 0

Array becomes

[0,2]

That is why your output becomes wrong.


*/