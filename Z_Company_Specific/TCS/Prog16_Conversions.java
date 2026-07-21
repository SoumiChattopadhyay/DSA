public class Prog16_Conversions {
    static int binaryToDecimal(String bin){
        return Integer.parseInt(bin,2);// Integer.parseInt() converts a string into an integer.
        // The second parameter (2) tells Java that the string is in base 2 (binary).
    }
    static String decimalToBinary(int dec){
        boolean flag=false;
        StringBuilder bin = new StringBuilder();
        for(int i=31;i>=0;i--){
            if(((dec>>i)&1)==1){
                flag=true;
                bin.append('1');
            }else{
                if(flag){
                    bin.append('0');
                }
            }
        }
        return bin.toString();
    }
    static String binaryToOctal(String bin){
        int n=bin.length();
        
        // Pad leading zeros to make length a multiple of 3
        if(n%3==1){
            bin = "00"+bin;
        }else if(n%3==2){
            bin="0"+bin;
        }

        // Update length after padding
        n = bin.length();
        
        StringBuilder oct = new StringBuilder();

        // Process every group of 3 bits
        for(int i=0;i<n;i+=3){
            
            // ASCII values of digit characters '0'–'9' are 48–57.
            // bin.charAt(i) returns the character '0' or '1', not the integer 0 or 1.
            // Subtracting '0' converts:
            // '0' -> 48 - 48 = 0
            // '1' -> 49 - 48 = 1
            // If we don't subtract '0', we would get ASCII values (48 or 49) instead of 0 or 1.
            int temp = (bin.charAt(i)-'0')*4 + (bin.charAt(i+1)-'0')*2 + (bin.charAt(i+2)-'0')*1;
            
            // temp is an integer from 0 to 7.
            // To append it as the digit character ('0' to '7'),
            // add the ASCII value of '0' (48) and convert it to char.
            // Example:
            // temp = 6
            // temp + '0' = 6 + 48 = 54
            // (char)54 = '6'
            oct.append((char)(temp+'0'));//temp is a number (0–7), not the ASCII value of the digit character. Say temp=6, (char)6 makes no sense. But (char)(temp+'0') means (char)(6+'0') means char(6+48) means char(54) means character '6'
        }

        return oct.toString();
    }
    static int octalToDecimal(int oct){
        int dec=0;
        int i=0;
        while(oct!=0){
            int rem=oct%10;
            dec+=rem*Math.pow(8,i);
            i++;
            oct/=10;
        }
        return dec; 
    }
    static String octalToBinary(int oct){
        int dec = octalToDecimal(oct);
        String bin = decimalToBinary(dec);
        return bin;
    }
    public static void main(String[] args) {
        String s="1011";
        System.out.println(binaryToDecimal(s));
        int n=11;
        System.out.println(decimalToBinary(n));
        s="110101011";
        System.out.println(binaryToOctal(s));
    }
}

/*
Algorithm(Decimal to Binary)
By using right shift operator move to the ith bit.
Now using “and” operator check if the bit is set or not.
If bit is set print 1,else print 0.

Approach(Binary to Octal)
Take the binary string s and find its length.
If the length is not a multiple of 3, pad leading zeros to make it so.
Iterate through the string in steps of 3 characters at a time.
For each group of three bits, convert them into their decimal equivalent using positional values (4, 2, 1).
Append the converted digit to the result string ans.
Print the final octal representation.

Algorithm(Octal to Binary)
For Octal to Binary Conversion, we will first convert Octal Number System to Decimal Number System and then convert Decimal Number System to Binary Number System.
For Octal to Decimal Conversion:
We will take every digit of the number and multiply it with 8 raised to power i which will increase by 1 when we move to the next digit and then add it to sum. This task is repeated until n becomes 0.
For Decimal to Binary Conversion:
For Decimal to Binary Conversion, we will divide the given number by 2 ( Since the Binary Numbers System has 2 digits in use ) repeatedly, and its remains will be stored till the number becomes zero.


Don't start with 32
As n >> 32 is actually the same as n >> 0
If the least significant bit of n is 1 (for example, 11 is 1011₂), your code immediately finds a 1, sets:
flag = true;
and then starts printing all the remaining bits, producing:
1 00000000000000000000000000001011


Normally,
n >> 0
means shift by 0 places, so the number stays the same:

But what about n >> 32?
You might think shifting by 32 would move all bits out and give 0.
Java does NOT do that for int.
Before shifting, Java calculates:
shift amount = shift amount & 31
Since 31 in binary is:
11111
only the lowest 5 bits of the shift count are used.


Step 1: What is Binary?
Binary is base 2.
Each position has powers of 2.
101101₂
=1×2⁵ +0×2⁴ +1×2³ +1×2² +0×2¹ +1×2⁰

Step 2: What is Octal?
Octal is base 8.
Each position has powers of 8.
572₈
=5×8² +7×8¹ +2×8⁰

Step 3: Here's the Magic
Notice:
8 = 2³
That means one octal digit can represent exactly 3 binary bits.
Why?
Let's see.
1 Binary Bit
Only 2 Possible values:0 1
2 Binary Bits
There are 2² = 4 possible values : 00 01 10 11
3 Binary Bits
000
001
010
011
100
101
110
111
How many?
2³ = 8
Exactly 8 values.
And octal also has 8 digits:
0
1
2
3
4
5
6
7
That's why 3 binary bits = 1 octal digit.

Bigger Example
Suppose 110101011
Instead of converting the whole thing into decimal first...
Break it into groups of 3.
110   101   011
Now each group is already one octal digit.
First group: 110
Decimal: 6
So octal digit: 6
Second: 101
Decimal: 5
Third: 011
Decimal: 3
So answer 653₈

Consider one group
110
This is binary, not octal.
So we must use binary place values, which are:
1  1  0
↑  ↑  ↑
4  2  1
Why?
Because binary uses powers of 2.
2² = 4
2¹ = 2
2⁰ = 1
Now calculate:
110₂
=1×4 +1×2 +0×1
=6
Now we know:
110₂ = 6₈
Notice we didn't multiply by 8 because we weren't evaluating an octal number—we were evaluating a binary group.

Where does 8 come in? 
After converting each 3-bit group into a single digit, those digits together form an octal number. 
Example: 110101011₂ 
Group into 3 bits: 110 101 011 
Now convert each group using 4, 2, 1: 
First: 110 =1×4 +1×2 +0×1 =6 
Second: 101 =1×4 +0×2 +1×1 =5 
Third: 011 =0×4 +1×2 +1×1 =3 
So the octal number is: 653₈

The rule is:
Length % 3 = 0 → No padding needed.
Length % 3 = 1 → Pad 2 leading zeros.
Length % 3 = 2 → Pad 1 leading zero.

Why?
You want the total length to become a multiple of 3.

Examples:
    OriginalLength	    Length % 3	    Zeros to Add	New Length
        7	                1	            2	            9
        8	                2	            1	            9
        10	                1	            2	            12
        11	                2	            1	            12

A simple memory trick is:
Remainder 1 → Need 2 more digits to reach the next multiple of 3.
Remainder 2 → Need 1 more digit to reach the next multiple of 3.

The weights are assigned from left to right because the leftmost bit is the Most Significant Bit (MSB).

*/
