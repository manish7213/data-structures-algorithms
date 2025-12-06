package DP.Pattern_04_MatrixChainMultiplcation;

import java.util.Arrays;

// DISCLAIMER : LEARN IT FOR CONCEPT, DOES NOT WORK ON Leetcode (TLE). Binary Search will be the correct approach
/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=jkygQmOiCCI&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=44">YouTube: EggDroppingProblem</a>
 * <p>
 * <a href="https://leetcode.com/problems/super-egg-drop/">LC: EggDroppingProblem</a>
 * <p>
 * <p>
 */
public class Q25_EggDroppingProblem {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return superEggDropHelper(k, n, dp);
    }

    public int superEggDropHelper(int k, int n, int[][] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (k == 1) {
            return n;
        }

        if (dp[k][n] != -1) {
            return dp[k][n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int res1;
            int res2;
            if (dp[k - 1][i - 1] != -1) {
                res1 = dp[k - 1][i - 1];
            } else {
                res1 = superEggDropHelper(k - 1, i - 1, dp);
            }

            if (dp[k][n - i] != -1) {
                res2 = dp[k][n - i];
            } else {
                res2 = superEggDropHelper(k, n - i, dp);
            }

            int temp = 1 + Math.max(res1, res2);
            min = Math.min(min, temp);
        }

        dp[k][n] = min;
        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(new Q25_EggDroppingProblem().superEggDrop(1, 2));
        System.out.println(new Q25_EggDroppingProblem().superEggDrop(2, 6));
    }
}
