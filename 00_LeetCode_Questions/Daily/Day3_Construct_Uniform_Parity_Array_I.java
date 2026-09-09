/*
3875. Construct Uniform Parity Array I
You are given an array nums1 of n distinct integers.
You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.
For each index i, you must choose exactly one of the following (in any order):
nums2[i] = nums1[i]
nums2[i] = nums1[i] - nums1[j], for an index j != i
Return true if it is possible to construct such an array, otherwise, return false.

Example 1:
Input: nums1 = [2,3]
Output: true
Explanation:
Choose nums2[0] = nums1[0] - nums1[1] = 2 - 3 = -1.
Choose nums2[1] = nums1[1] = 3.
nums2 = [-1, 3], and both elements are odd. Thus, the answer is true​​​​​​​.

Example 2:
Input: nums1 = [4,6]
Output: true
Explanation:​​​​​​​
Choose nums2[0] = nums1[0] = 4.
Choose nums2[1] = nums1[1] = 6.
nums2 = [4, 6], and all elements are even. Thus, the answer is true.
 

Constraints:
1 <= n == nums1.length <= 100
1 <= nums1[i] <= 100
nums1 consists of distinct integers.

Hint 1
There is only one possible answer.

Topics
Mid Level  Array  Math
*/

/*
Explanation:
    The key is to look only at parity (odd/even).
    Parity rules :
        Even − Even = Even
        Odd − Odd = Even
        Even − Odd = Odd
        Odd − Even = Odd

    Because the array has distinct integers, if there are both odd and even numbers, then:
    An odd element can stay odd.
    An even element can subtract an odd → becomes odd.
    So all elements can be made odd.

    If all numbers are already the same parity, they can simply remain unchanged.
    
    Therefore, the answer is always true.

    The hint says "There is only one possible answer" → that's the trick.

    array length does NOT matter at all. 😭
    whether array length is odd or even it doesnt matter
    For example:
        n = 1
        [5]
        Just keep it:
        [5] → all odd → ✅ true

        n = 2 (even length)
        [2, 3]
        2 - 3 = -1 → odd
        3 → odd
        [-1, 3] → all odd → ✅

        n = 3 (odd length)
        [2, 4, 7]
        Use 7 as the odd number to subtract:
        2 - 7 = -5 → odd
        4 - 7 = -3 → odd
        7 → odd
        [-5, -3, 7] → all odd → ✅

        n = 4 (even length)
        [2, 4, 6, 8]
        They're all even, so keep them:
        [2, 4, 6, 8] → all even → ✅
*/
public class Day3_Construct_Uniform_Parity_Array_I {
    static boolean uniformArray(int[] nums1){
        return true;
    }
    public static void main(String[] args) {
        int[] nums1 = {2,3,5};//{2,-2} or {2,2}
        System.out.println(uniformArray(nums1));
    }
}
