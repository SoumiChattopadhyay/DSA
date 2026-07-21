/*
Travelling Salesman Problem

Problem Statement:
A salesman has to visit N cities, numbered from 0 to N − 1. The travel cost between every pair of 
cities is given in the form of an N × N cost matrix, where cost[i][j] represents the cost of 
travelling from city i to city j.
The salesman starts from city 0, visits every other city exactly once, and finally returns to city 0.
Your task is to determine the minimum possible travel cost to complete the journey.

Input Format
The first line contains a single integer N, representing the number of cities.
The next N lines each contain N space-separated integers, where the jth integer in the ith line denotes cost[i][j], the cost of travelling from city i to city j.

Output Format
Print a single integer representing the minimum cost required to visit all cities exactly once and
return to the starting city.

Constraints
2 ≤ N ≤ 15
0 ≤ cost[i][j] ≤ 10^6
cost[i][i] = 0

Sample Input
4
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0

Sample Output
80

*/

import java.util.*;

public class Prog59_Travelling_Salesman {
    static final int INF = (int) 1e9;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int totalMask = 1 << n;

        int[][] dp = new int[totalMask][n];

        for (int[] row : dp)
            Arrays.fill(row, INF);

        // Start from city 0
        dp[1][0] = 0;

        for (int mask = 1; mask < totalMask; mask++) {

            for (int u = 0; u < n; u++) {

                // Current city not visited
                if ((mask & (1 << u)) == 0)
                    continue;

                if (dp[mask][u] == INF)
                    continue;

                for (int v = 0; v < n; v++) {

                    // Already visited
                    if ((mask & (1 << v)) != 0)
                        continue;

                    int nextMask = mask | (1 << v);

                    dp[nextMask][v] = Math.min(
                            dp[nextMask][v],
                            dp[mask][u] + cost[u][v]
                    );
                }
            }
        }

        int answer = INF;

        int fullMask = totalMask - 1;

        for (int i = 1; i < n; i++) {
            answer = Math.min(answer,
                    dp[fullMask][i] + cost[i][0]);
        }

        System.out.println(answer);

        sc.close();
    }
}
