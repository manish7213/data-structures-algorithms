package DP;

/**
 * @author manishkumar
 * <p>
 * <a href="https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8">YouTube: partition-equal-subset-sum</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/dsa/partition-problem-dp-18/">GFG: partition-equal-subset-sum</a>
 * <p>
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/">Leetcode: partition-equal-subset-sum</a>
 */

public class Q3_EqualSumPartition {

    public boolean canPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        //Since this partition must be equal , hence sum must be even and if we find half of the sum then we will find the solution as subset sum;
        int target = sum / 2;
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

}
