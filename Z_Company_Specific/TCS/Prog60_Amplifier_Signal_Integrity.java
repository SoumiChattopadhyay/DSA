/*
Amplifier Signal Integrity

A communication network consists of N amplifiers. Each amplifier has a power signal.
Since the network is dynamic, the power signal of an amplifier can be updated at any time. You are 
required to process Q queries of the following two types:
    1 index value – Update the power signal of the amplifier at the given index to value.
    2 L R – Print the signal integrity of the amplifier segment from L to R (both inclusive) by 
    calculating the Greatest Common Divisor (GCD) of all power signals in that range.
Input Format
    The first line contains 2 space-separated integers N (number of amplifiers) and Q (number of queries).
    The second line contains N space-separated integers P_0, P_1, ..., P_N-1 representing the power signals of the amplifiers.
    The next Q lines describe one of the following two operations:
        1 index value – Since the network is dynamic, update the power signal of the amplifier at the given index to value.
        2 L R – Print the signal integrity of the amplifier segment from L to R by calculating the GCD of all power signals in that range.
Output Format
For every query of type 2, print the signal integrity (GCD) of the specified range on a new line.
Constraints
1 ≤ N ≤ 100000
1 ≤ Q ≤ 100000
1 ≤ P[i] ≤ 10^9
0 ≤ index < N
0 ≤ L ≤ R < N
Sample Input
5 3
2 1 3 5 7
1 2 5
2 1 4
2 3 4
Sample Output
1
1
*/

import java.util.*;

public class Prog60_Amplifier_Signal_Integrity {
    static int[] power;
    static int[] tree;

    // Function to calculate GCD
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Build Segment Tree
    static void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = power[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    // Update a value
    static void update(int node, int start, int end, int idx, int value) {

        if (start == end) {
            power[idx] = value;
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node, start, mid, idx, value);
        else
            update(2 * node + 1, mid + 1, end, idx, value);

        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    // Range GCD Query
    static int query(int node, int start, int end, int left, int right) {

        // No Overlap
        if (right < start || end < left)
            return 0;

        // Complete Overlap
        if (left <= start && end <= right)
            return tree[node];

        // Partial Overlap
        int mid = (start + end) / 2;

        int leftGCD = query(2 * node, start, mid, left, right);
        int rightGCD = query(2 * node + 1, mid + 1, end, left, right);

        return gcd(leftGCD, rightGCD);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        power = new int[N];
        tree = new int[4 * N];

        // Input power signal array
        for (int i = 0; i < N; i++)
            power[i] = sc.nextInt();

        // Build Segment Tree
        build(1, 0, N - 1);

        // Process Queries
        while (Q-- > 0) {

            int choice = sc.nextInt();

            if (choice == 1) {

                int index = sc.nextInt();
                int value = sc.nextInt();

                update(1, 0, N - 1, index, value);

            } else if (choice == 2) {

                int L = sc.nextInt();
                int R = sc.nextInt();

                System.out.println(query(1, 0, N - 1, L, R));
            }
        }

        sc.close();
    }
}
