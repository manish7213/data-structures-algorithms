package DP;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16">YouTube: Q11_CoinChange_MinNoOfCoins</a>
 * <p>
 * <a href="https://leetcode.com/problems/coin-change/">Leetcode: Q11_CoinChange_MinNoOfCoins</a>
 */
public class Q11_CoinChange_MinNoOfCoins {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        //Initialization
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        //Code
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[n][amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return dp[n][amount];
    }
}
