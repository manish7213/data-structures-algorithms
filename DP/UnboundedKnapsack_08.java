package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14">YouTube: Unbounded-knapsack</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1">GFG: Unbounded-knapsack</a>
 */
public class UnboundedKnapsack_08 {

    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n + 1][capacity + 1];

        //Initialize
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }


        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = 0;
        }

        //Code
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}
