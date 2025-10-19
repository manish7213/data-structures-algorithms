package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=17">YouTube: CoinChange_MaxNoOfWays</a>
 * <p>
 * <a href="https://leetcode.com/problems/coin-change-ii/">Leetcode: CoinChange_MaxNoOfWays</a>
 */
public class CoinChange_MaxNoOfWays {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        //initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }

        //code

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

}
