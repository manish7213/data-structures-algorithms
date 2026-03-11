package DP.Pattern_01_ZeroOneKnapsack;

import java.util.Arrays;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5">YouTube: 0-1-knapsack</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1">GFG: 0-1-knapsack</a>
 */
public class Q1_ZeroOneKnapsack {
    static int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    static int knapsackRecursive(int W, int[] val, int[] wt) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return knapsackHelper(W, val, wt, n,dp);
    }

    private static int knapsackHelper(int W, int[] val, int[] wt, int n, int[][] dp) {

        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        int notTaken = knapsackHelper(W, val, wt, n - 1, dp);
        if (wt[n - 1] <= W) {
            int taken = val[n-1] + knapsackHelper(W - wt[n - 1], val, wt, n - 1, dp);
            dp[n][W] = Math.max(taken, notTaken);
        } else {
            dp[n][W] = notTaken;
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        System.out.println(knapsackRecursive(W, val, wt));
    }
}
