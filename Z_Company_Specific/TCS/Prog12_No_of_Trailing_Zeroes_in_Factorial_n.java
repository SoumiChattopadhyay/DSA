/*
Trailing zeroes in factorial
For an integer n, find the number of trailing zeroes in n!.
*/
public class Prog12_No_of_Trailing_Zeroes_in_Factorial_n {
    static int funct(int n){
        int count=0;
        for(int i=5;i<=n;i*=5){
            count+=n/i;
        }
        return count;
    }
    public static void main(String[] args) {
        int n=30;
        System.out.println(funct(n));
    }
}
/*
Algorithm
Initialize count = 0.
Divide n by 5 and add the quotient to count.
Divide by 25 and add the quotient.
Divide by 125 and add the quotient.
Continue until the divisor becomes greater than n.

Example: n = 30
We want the trailing zeros in 30!.
One 10 gives one trailing zero.
10=5*2
So no. of 5s = no. of 10s = no. of 0s

Step 1: Why count += 30 / 5?
30 / 5 = 6
What does 6 mean?
It means there are 6 multiples of 5 between 1 and 30.
Those are:
5
10
15
20
25
30

So by doing
count += 30 / 5;
we are actually doing
count = 6
because we've found 6 factors of 5.

30! = 30 × 29 × 28 × ... × 3 × 2 × 1

So in count variable we already counted these no.s in that 30! :
5
10
15
20
25
30

Then why do we do division by 25 and 125 next...is that even needed?
Example: 25!

Numbers in 25! are:

1 × 2 × 3 × ... × 24 × 25

Now count the numbers divisible by 5.

5
10
15
20
25

There are 5 of them.

So if we only do:
count = 25 / 5;

we get
count = 5

But is that correct?

Look carefully at 25.
25 = 5 × 5

It has two 5s, not one.

Let's write them:
5  → one 5
10 → one 5
15 → one 5
20 → one 5
25 → TWO 5s

Total number of 5s:
1 + 1 + 1 + 1 + 2 = 6

But our formula gave 5.

We're missing one extra 5.

That's why we add
25 / 25

which is
25 / 25 = 1
That 1 represents the extra 5 inside 25.

Now
5 + 1 = 6
Correct!

*/