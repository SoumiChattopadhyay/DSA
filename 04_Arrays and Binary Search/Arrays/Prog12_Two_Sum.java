/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. 
*/


/*What the problem gives you
    An array of integers nums
    An integer target

Example:
nums = [2, 7, 11, 15]
target = 9

Find two indices (positions in the array) such that:
    nums[i] + nums[j] = target
    and i ≠ j (you cannot use the same element twice).

Important rules
    You must return the indices, not the numbers.
    You cannot use the same element twice.
    The problem guarantees exactly one valid pair exists.
    The order of indices in the answer doesn't matter. 
*/

import java.util.Arrays;
import java.util.HashMap;

public class Prog12_Two_Sum {
    static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);//(key,val)
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
