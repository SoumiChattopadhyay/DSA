/*
3876. Construct Uniform Parity Array II

You are given an array nums1 of n distinct integers.
You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.
For each index i, you must choose exactly one of the following (in any order):
nums2[i] = nums1[i]​​​​​​​
nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
Return true if it is possible to construct such an array, otherwise return false.

Example 1:
Input: nums1 = [1,4,7]
Output: true
Explanation:​​​​​​​​​​​​​​
Set nums2[0] = nums1[0] = 1.
Set nums2[1] = nums1[1] - nums1[0] = 4 - 1 = 3.
Set nums2[2] = nums1[2] = 7.
nums2 = [1, 3, 7], and all elements are odd. Thus, the answer is true.

Example 2:
Input: nums1 = [2,3]
Output: false
Explanation:
It is not possible to construct nums2 such that all elements have the same parity. Thus, the answer is false.

Example 3:
Input: nums1 = [4,6]
Output: true
Explanation:
Set nums2[0] = nums1[0] = 4.
Set nums2[1] = nums1[1] = 6.
nums2 = [4, 6], and all elements are even. Thus, the answer is true.
 

Constraints:
1 <= n == nums1.length <= 105
1 <= nums1[i] <= 109
nums1 consists of distinct integers.

Hint 1
Try fixing the parity to either all even or all odd.

Hint 2
Use the smallest odd/even element if a subtraction is needed to match the chosen parity.

Topics
Senior Array Math Weekly Contest 494
*/

/*
Explanation:

Case 1: Make everything even
An even number can simply stay as it is.
An odd number must subtract another odd number, because: odd - odd = even.
The subtracted odd number must be smaller. (Because the problem has an important condition: nums1[i] - nums1[j] >= 1, So the result of subtraction must be positive.)
So:
If there are 0 odd numbers → possible.
If there is 1 or more odd numbers → impossible, because the smallest odd number cannot subtract any smaller odd number.
    Example: In [2,7,11], 11 can be changed to 11-7=4 but 7 has to stay 7 as there is no smaller odd no.

Case 2: Make everything odd
An odd number can stay as it is.
An even number must subtract an odd number: even - odd = odd.
That odd number must be smaller than the even number. (Because the problem has an important condition: nums1[i] - nums1[j] >= 1, So the result of subtraction must be positive.)
Therefore, if there are even numbers, we need: smallestOdd < everyEvenNumber
So the simplest check is smallestOdd < smallestEven.

Why did we consider even - odd and not odd - even in Case 2?
yes, odd − even is absolutely a valid possibility.
But we didn't do so because we don't need to modify an odd number at all.
If we're targeting all odd:
Every odd number → keep it
Every even number → must change
An even number can only become odd by subtracting an odd number.

Time: O(n)
Space: O(1)
*/
public class Day4_Construct_Uniform_Parity_Array_II{
    static boolean uniformArray(int[] nums1){
        
        int oddCount=0;
        int smallestOdd=Integer.MAX_VALUE;
        int smallestEven=Integer.MAX_VALUE;

        for(int x:nums1){
            if(x%2==0){
                smallestEven=Math.min(smallestEven,x);
            }else{
                oddCount++;
                smallestOdd=Math.min(smallestOdd,x);
            }
        }
        
        if(oddCount==0){//All even no.s present
            //Making everything even is possible
            return true;
        }

        // If there are odd numbers, all-even is impossible.
        // So try making everything odd.

        // No even numbers -> already all odd
        if (smallestEven==Integer.MAX_VALUE) {
            return true;
        }

        // It is possible to make all-odd if the smallest odd no. is smaller than every other even no.
        // Or we can say it is possible if simply the smallest odd no. is smaller than the smallest even no.
        return smallestOdd<smallestEven;//no need for <= as the no.s are distinct 
    }
    public static void main(String[] args) {
        int[] nums1 = {2,7,11};
        System.out.println(uniformArray(nums1));
    }
}