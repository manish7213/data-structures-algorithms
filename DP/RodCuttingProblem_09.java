package DP;

import java.util.stream.IntStream;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14">YouTube: Rod Cutting</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/rod-cutting0840/1">GFG: Rod Cutting</a>
 */
public class RodCuttingProblem_09 {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;

        int[] len = IntStream.rangeClosed(1, n)
                .toArray();

        int[][] dp = new int[n + 1][n + 1];

        //initilize

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }

        //code
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][n];
    }
}
