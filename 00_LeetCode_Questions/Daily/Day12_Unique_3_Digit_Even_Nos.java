/*
3483. Unique 3-Digit Even Numbers
You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.
Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.

Example 1:
Input: digits = [1,2,3,4]
Output: 12
Explanation: The 12 distinct 3-digit even numbers that can be formed are 124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432. Note that 222 cannot be formed because there is only 1 copy of the digit 2.

Example 2:
Input: digits = [0,2,2]
Output: 2
Explanation: The only 3-digit even numbers that can be formed are 202 and 220. Note that the digit 2 can be used twice because it appears twice in the array.

Example 3:
Input: digits = [6,6,6]
Output: 1
Explanation: Only 666 can be formed.

Example 4:
Input: digits = [1,3,5]
Output: 0
Explanation: No even 3-digit numbers can be formed.

Constraints:
3 <= digits.length <= 10
0 <= digits[i] <= 9

*/

/*
Brute Logic
    We need to form a 3-digit even number.

    So there are 3 conditions:
    Hundreds digit cannot be 0
    Each copy of a digit can be used only once
    Last digit must be even → 0, 2, 4, 6, 8

    Since there are only 10 possible digits, we can simply try every possible 3-digit number from 100 to 999.

    For each number:
    Check if it is even.
    Check whether its digits are available in the given array.
    Use each digit only as many times as it appears in the array.
    Count each valid number once.

Optimal Logic
    We need to make a 3-digit even number.

    So remember just 3 rules:

    First digit cannot be 0
    Last digit must be even
    A digit can be used only as many times as it appears

    We use freq[] to know how many times each digit is available.

    Case 1: All 3 digits are different
    Choose:
    1st digit → any non-zero digit
    2nd digit → another unused digit
    3rd digit → an even digit
    This is what: even * (all - 1) * (all - 2) is trying to count.
    Then we remove the invalid numbers where 0 was accidentally chosen as the first digit.

    Case 2: Two digits are the same
    If:
    freq[i] >= 2
    we can use that digit twice.
    We separately handle whether i is:
        0
        odd
        non-zero even
    because the first digit cannot be 0 and the last digit must be even.

    Case 3: All 3 digits are the same
    If an even digit appears at least 3 times:
    222, 444, 666, 888
    we can make one such number.
    Simply put:
    Count numbers with 3 different digits + numbers with 2 same digits + numbers with 3 same digits.

    The freq[] array makes sure we don't use a digit more times than we actually have.

    
    int count = even * all-2 * all-1;
        Units digit - It must be even so even no. of choices.
        
        Hundreds digit - It cannot be 0. So, there are all - 1 choices.
        
        Tens digit - After choosing the units digit and hundreds digit, there are all - 2 remaining digits 
        if all 3 digits must be different.
*/
public class Day12_Unique_3_Digit_Even_Nos{
    // Brute
    static int totalNumbers(int[] digits) {
        // Count how many times each digit appears
        int[] freq = new int[10];
        for(int i=0;i<digits.length;i++){
            freq[digits[i]]++;
        }
        int count=0;
        // Try every 3-digit number
        for(int num=100;num<=999;num++){
            // We only need even 3-digit number
            if(num%2!=0){
                continue;
            }
            // Check whether required digits are available
            int a = num/100;
            int b = (num/10)%10;
            int c = num%10;
            if(a==b && b==c){
                if(freq[a]>=3){
                    count++;
                }
            }
            else if(a==b){
                if(freq[a]>=2 && freq[c]>=1){
                    count++;
                }
            }
            else if(a==c){
                if(freq[a]>=2 && freq[b]>=1){
                    count++;
                }
            }
            else if(b==c){
                if(freq[b]>=2 && freq[a]>=1){
                    count++;
                }
            }
            else{
                if(freq[a]>=1 && freq[b]>=1 && freq[c]>=1){
                    count++;
                }
            }
        }
        return count;        
    }
    static int totalNumbers2(int[] digits){
        // Count how many times each digit appears
        int[] freq = new int[10];//0-9
        for(int digit:digits){
            freq[digit]++;
        }
        // Count no. of distinct digits, even digits and zeroes  {Distinct digits means different digits, without counting duplicates multiple times.}
        int all=0, even=0, zero=0;
        for(int i=0;i<10;i++){
            if(freq[i]>0){
                if(i%2==0) even++;
                if(i==0) zero++;
                all++;
            }            
        }
        // No. of all possible 3 digit even no.s
        int count = even*(all-1)*(all-2);

        // Removing 3 digit even no.s starting with 0
        for(int i=0; i<10; i++){
            if (freq[i]>=2){
                if (i==0) count+=all-1;
                else if (i%2==1) count+=even;
                else{
                    count+=3*(even-1)-zero;
                    count+=2*(all-even);
                }           
            }
        }

        for(int i=2; i<10; i+=2)if (freq[i]>=3)count++;
            
        
        return count;
    }
    public static void main(String[] args) {
        int[] digits = {1,2,2,3,4,4};
        System.out.println(totalNumbers(digits));
    }
}
/*
453
a = 453/100 = 4
b = (453/10)%10 = (45)%10 = 5
c = 453%10 = 3
*/