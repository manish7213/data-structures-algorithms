package DP;

import java.util.Arrays;

/**
 * @author manishkumar
 * <p>
 * <a href="https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13">YouTube:Target Sum</a>
 * </p>
 * <p>
 * <a href="https://leetcode.com/problems/target-sum/description/">Leetcode: Target Sum</a>
 * </p>
 */
public class TargetSum_07 {

    public int findTargetSumWays(int[] nums, int d) {
        //consider target as diff as plus and minus will be distributed

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        // IMPORTANT
        if ((sum + d) % 2 != 0 || sum < d || sum + d < 0) {
            return 0;
        }
        int target = (sum + d) / 2;
        int[][] dp = new int[n + 1][target + 1];

        //initilization

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= target; j++) {
            dp[0][j] = 0;
        }

        //code

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];

    }
}
