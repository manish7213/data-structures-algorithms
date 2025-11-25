package DP;

import java.util.Arrays;

/**
 * @author manishkumar
 * <p>
 * <a href="https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11">YouTube: minimum-sum-partition</a>
 * </p>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1">GFG: minimum-sum-partition</a>
 * </p>
 */
public class Q5_MinimumSubsetSumDifference {

    public int minDifference(int arr[]) {
        int n = arr.length;
        int range = Arrays.stream(arr).sum();

        boolean[][] dp = new boolean[n + 1][range + 1];

        //initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        //Code
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int s1 = 0;

        for (int i = 0; i <= range / 2; i++) {
            if (dp[n][i] == true) { // last row of the dp matrix
                s1 = i;
            }
        }

        return range - 2 * s1;

    }

}
