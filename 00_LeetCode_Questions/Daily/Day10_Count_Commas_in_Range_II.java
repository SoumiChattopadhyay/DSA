/*
3871. Count Commas in Range II
You are given an integer n.
Return the total number of commas used when writing all integers from [1, n] (inclusive) in standard number formatting.
In standard formatting:
A comma is inserted after every three digits from the right.
Numbers with fewer than 4 digits contain no commas.
 
Example 1:
Input: n = 1002
Output: 3
Explanation:
The numbers "1,000", "1,001", and "1,002" each contain one comma, giving a total of 3.

Example 2:
Input: n = 998
Output: 0
Explanation:
​​​​​​​All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.

Constraints:
1 <= n <= 10^15

Hint 1
Count the numbers in each comma group (1-3 digits, 4-6 digits, 7-9 digits, ...) and multiply by how many commas each number in that group has.
*/

/*
Explanation: 
    Suppose n = 1,000,000,000,000,000
    We obviously cannot go through all 10^15 numbers(1 to 1,000,000,000,000,000). So we need to find a pattern.
    When does a number get its first comma?
    A comma is placed after every 3 digits from the right.
    So numbers naturally form groups.
        1-3 digits : 0 commas
        4-6 digits : 1 comma (Ex: 1,000 and 100,000)
        7-9 digits : 2 commas (Ex: 1,000,000 and 100,000,000)
        10-12 digits : 3 commas (Ex: 1,000,000,000 and 100,000,000,000)
        13-15 digits : 4 commas (Ex: 1,000,000,000,000 and 100,000,000,000,000)
    The important observation is:
        Every number within the same digit group has the same number of commas.
        Therefore, instead of examining individual numbers, we can simply count how many numbers are in each group and multiply.
    How do we count a group?
        Suppose n = 5000
        The 4–6 digit group normally goes: 1000 → 999999
        But our n is only 5000.
        So we only care about: 1000 → 5000
        Number of numbers:
        5000 - 1000 + 1 = 4001
        Each has 1 comma.
        Therefore:
        4001 × 1 = 4001
    How do we find the end of a group?
        For the group starting at: 1000
        the next group starts at: 1,000,000
        Therefore the current group ends at: 999,999
        We can calculate this as:
            1000 × 1000 - 1
            = 999999
        For the next group: 
            start = 1,000,000
        Its end is:
            1,000,000 × 1000 - 1
            = 999,999,999
        So we can repeatedly do:
            end = start * 1000 - 1;
    Example:
        n = 1,000,002
        Initially: start = 1000, commas = 1, answer = 0
        First group
            start = 1000
            end = 999999
            But n = 1,000,002, so the entire group is included.
            Number of numbers:
                999999 - 1000 + 1
                = 999000
            Each has 1 comma:
                999000 × 1 = 999000
            So: 
                answer = 999000
        
        Second group
            Now move to:
                start = 1000000
                commas = 2
            Its normal end is: 999999999
            But n is only: 1000002
            So we stop at n.
            That's why we use:
                end = Math.min(n, start * 1000 - 1);
            Therefore:
                end = 1000002
            Number of numbers:
                1000002 - 1000000 + 1
                = 3
            Each has 2 commas:
                3 × 2 = 6

        Final answer:
            999000 + 6
            = 999006
*/
public class Day10_Count_Commas_in_Range_II{
    static long countCommas(long n) {
        long start=1,end=1,answer=0;
        int commas=0;
        while(start<=n){
            end=Math.min(n,start*1000-1);
            answer+=(end-start+1)*commas++;
            start*=1000;
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(countCommas((long)Math.pow(10,15)));
    }
}