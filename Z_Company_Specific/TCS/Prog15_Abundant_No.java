/*
Example 1:
Input: 18
Output: Abundant Number
Explanation: Divisors of 18 are 1,2,3,6,9. 1+2+3+6+9=21, Since 21 is greater than 18, 18 is an abundant number.

Example 2:
Input: 21
Output: Not Abundant Number
Explanation:Divisors of 21 are 1,3,7. 1+3+7=11, Since 11 is smaller than 21, 11 is not an abundant number.

*/

public class Prog15_Abundant_No {
    static boolean funct(int n){
        int sum=0;
        for(int i=1;i<Math.sqrt(n);i++){
            if(n%i==0){// If i is a divisor of n
                if(n/i==i){//If i is a square root of n. Say n=36 and i=6, so n/i=6 too then dont add both i and n/i to the sum of divisors
                    sum+=i;
                }
                else{// Add both i and n/i to the sum of divisors
                    sum+=i;
                    sum+=n/i;
                }
            }
        }
        // Subtract the number itself from the sum of divisors
        sum -= n;

        if(sum>n) return true;
        else return false;
    }
    public static void main(String[] args) {
        int n=18;
        System.out.println(funct(n));
    }
}
/*
Algorithm
Traverse from 1 to square root of n.
Maintain a variable, sum, to calculate sum of divisors.
If i is a factor of n,add it to the sum as well as add n/i to the sum.But don’t forget to check if i and n/i are same or not.For instance if i=6 and n=36,then i and n/i will have same value and it will not make sense to add both i and n/i,i.e 6 two times.

Instead of checking from 1 to 18, we check only till √18 ≈ 4.24.
Why?
Because divisors always come in pairs.

Example for 18
i	Pair
1	18
2	9
3	6

After √18, the pairs repeat.

This reduces time complexity from O(n) to O(√n).


*/