/*
13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is 
XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the 
numeral for four is not IIII. Instead, the number four is written as IV. Because the one is 
before the five we subtract it making four. The same principle applies to the number nine, 
which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

Hint 1
Problem is simpler to solve by working the string from back to front and using a map.
*/

/*
Explanation of Method 1: 
    Normally, Roman numerals go largest → smallest, so we add.
    Example:
    XII = 10 + 1 + 1 = 12

    But when a smaller value comes before a larger value, we subtract it.
    Example:
    IV
    I = 1
    V = 5
    Since 1 < 5, do 5 - 1 = 4.

    So while traversing the string:
    If current value < next value → subtract current. Otherwise → add current.
*/

/*
Explanation of Method 2: 
    The main idea is to traverse the Roman numeral from right to left using a HashMap to store the value of each Roman symbol.

    Normally, Roman numerals are written from larger to smaller values, so we add the values.

    However, when a smaller value appears before a larger value, it must be subtracted.

    When traversing from right to left, we can detect this by keeping track of the largest value seen so far on the right.

    If the current value is smaller than the largest value on its right, subtract it.
    Otherwise, add it.
    After adding a value, if it is larger than maxRight, update maxRight.
*/

/*
TC and SC
    1. Left → Right method
        for (int i = 0; i < s.length(); i++)

        We visit each character exactly once.

        Time Complexity: O(n)
        Space Complexity: O(1)

        The value() method uses only a fixed switch with 7 Roman symbols, so it doesn't depend on n.

    2. Right → Left + HashMap method
        Map<Character, Integer> map = new HashMap<>();

        The map contains only 7 entries (I, V, X, L, C, D, M), regardless of the input size.

        Then:

        for (int i = s.length() - 1; i >= 0; i--)

        visits every character once.

        Time Complexity: O(n)
        Space Complexity: O(1)
*/

import java.util.Map;
import java.util.HashMap;

public class Prog9_Roman_to_Int {
    static int romanToInt(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int curr=value(s.charAt(i));
            if(i+1<s.length() && curr<value(s.charAt(i+1))){//i + 1 < s.length() - This checks whether there is a next character. curr < value(s.charAt(i + 1)) - This compares the current Roman numeral with the next Roman numeral.
                ans-=curr;//subtract
            }else{
                ans+=curr;//add
            }
        }
        return ans;
    }
    static int value(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    static int romanToInt2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans=0;
        int maxRight=0;

        for(int i=s.length()-1;i>=0;i--){
            int curr=map.get(s.charAt(i));
            if(curr<maxRight){
                ans-=curr;//subtract
            }else{
                ans+=curr;//add
                maxRight=curr;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="MCMXCIV";
        System.out.println(romanToInt(s));
        System.out.println(romanToInt2(s));
    }
}
