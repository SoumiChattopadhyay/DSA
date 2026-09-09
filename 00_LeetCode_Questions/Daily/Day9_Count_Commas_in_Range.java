/*
3870. Count Commas in Range
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
All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.

Constraints:
1 <= n <= 10^5

Hint 1
Numbers in the range [1000, 100000] have one comma.
*/

/*
This is a Math / Counting problem. You don't need to actually format every number.
Key idea
    A comma appears:
    In numbers from 1 to 999 → 0 commas
    In numbers from 1000 to 9999 → 1 comma each
    In numbers from 10000 to 99999 → 1 comma each
    In numbers from 100000 to 999999 → 1 comma each
    Since n <= 10^5, every number has at most 1 comma
    So simply count how many numbers are at least 1000.
    That is: n - 999
    when n >= 1000.
*/
public class Day9_Count_Commas_in_Range {
    static int countCommas(int n){
        return (n>=1000)?n-999:0;
    }
    public static void main(String[] args) {
        int n=1002;
        System.out.println(countCommas(n));
    }
}
