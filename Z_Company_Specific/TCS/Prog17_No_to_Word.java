/*
Convert digits/numbers to words
Problem Statement: Given a number, convert it into the form of words.
Note:- Consider maximum no. of digits in the number as 4.
*/
public class Prog17_No_to_Word {
    static String funct(String str){
        // Words for single digits
        String singleDigit[] = {"zero","one","two","three","four","five", "six", "seven", "eight", "nine"};
        
        // Words for numbers from 10 to 19
        String twoDigits[] = {"ten","eleven","twelve","thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        
        // Words for multiples of ten from 20 onwards
        String tensMultiple[] = {"","","twenty","thirty","forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        // Words for higher powers
        String[] tensPower = {"hundred", "thousand"};

        // Store length of string
        int len = str.length();

        // Handle empty input
        if (len == 0) {
            return "";
        }

        // Handle single digit input
        else if(len==1){
            return singleDigit[str.charAt(0)-'0'];
        }

        StringBuilder ans = new StringBuilder();

        // Handle double digit, triple digit or four digit inputs
        // Loop through each digit
        for(int i=0;i<str.length();i++){//don't use len coz its value changes. Only use str.length()
            //If more than 2 digits remain
            if(len>2){
                // Store digit and it's place value
                if(str.charAt(i)-'0'!=0){
                    ans.append(singleDigit[str.charAt(i)-'0']+" ");
                    ans.append(tensPower[len-3]+" ");
                }
                len--;
            }
            //If less than equal to 2 digits remain
            else{
                // Handle numbers between 10 and 19
                if(str.charAt(i)-'0'==1){
                    ans.append(twoDigits[str.charAt(i+1)-'0']+" ");
                    return ans.toString();
                }
                // Handle multiples of 10 and following digit
                else if(str.charAt(i)-'0'!=0){
                    ans.append(tensMultiple[str.charAt(i)-'0']+" ");
                    if(str.charAt(i+1)-'0'!=0)
                        ans.append(singleDigit[str.charAt(i+1)-'0']+" ");
                    return ans.toString();
                }
                else{
                    // Tens digit is 0
                    if(str.charAt(i+1)-'0'!=0){
                        ans.append(singleDigit[str.charAt(i+1)-'0']);
                    }
                    return ans.toString();
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String n="7435";
        System.out.println(funct(n));
        n="105";
        System.out.println(funct(n));
    }
}
/*
Suppose the input is: 9090

Step 1: First digit (9)
So the first digit is in the thousands place.
9 → nine thousand
Output so far: nine thousand

Step 2: Second digit (0)
Now 3 digits remain.
This digit is in the hundreds place.
But it is 0, so we don't say: zero hundred ❌
We simply skip it.
Output is still: nine thousand

Step 3: Third digit (9)
Now only 2 digits remain.
The remaining number is: 90
This is no longer a thousand or hundred.
Now we must read it as a two-digit number.
Since the tens digit is 9, we say ninety.

Step 4: Fourth digit (0)
Since the last digit is 0,
we don't say ninety zero ❌
We stop.
Final output: nine thousand ninety

Now let's connect this to the code.

This line: if (len > 2)
means "Am I reading the thousand or hundred place?"
If yes, print
digit + thousand
or
digit + hundred

This line
len--;
means "I finished reading one digit."

Suppose the remaining number is 14
if (str.charAt(i) - '0' == 1)
which means:
"Is the tens digit 1?"
For 14:
1 == 1
Yes
Now the program does:
twoDigits[str.charAt(i+1)-'0']
The next digit is 4.
So:
twoDigits[4]
The array is:
Index  Value
0      ten
1      eleven
2      twelve
3      thirteen
4      fourteen
5      fifteen
...
So
twoDigits[4]
↓
fourteen



Step 1: Traverse each digit one by one
Step 2: Check if the current digit is in the thousand or hundred place
    if (len > 2)
    If more than 2 digits remain, the current digit belongs to either:
    Thousand place (len = 4)
    Hundred place (len = 3)
Step 3: Skip zeros
    if (str.charAt(i) - '0' != 0)
    If the digit is not zero, print it.

    Example:
    9 → print "nine"
    0 → print nothing

    This prevents outputs like:
    zero hundred
    zero thousand
Step 4: Print the digit
    System.out.print(singleDigit[str.charAt(i) - '0'] + " ");
Step 5: Print its place value
    System.out.print(tensPower[len - 3] + " ");
    Here,
    len = 4
    ↓
    len - 3 = 1
    ↓
    tensPower[1]
    ↓
    thousand
    
    Similarly,
    len = 3
    ↓
    len - 3 = 0
    ↓
    tensPower[0]
    ↓
    hundred

    So,
    Length Remaining    Place Printed
    ---------------------------------
    4                   thousand
    3                   hundred

*/