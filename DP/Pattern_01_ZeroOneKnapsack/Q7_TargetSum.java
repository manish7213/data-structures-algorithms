package DP.Pattern_01_ZeroOneKnapsack;

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
public class Q7_TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        //consider target as diff as plus and minus will be distributed

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        // IMPORTANT
        if ((sum + target) % 2 != 0 || sum < target || sum + target < 0) {
            return 0;
        }
        int derivedTarget = (sum + target) / 2;
        int[][] dp = new int[n + 1][derivedTarget + 1];

        //initilization

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= derivedTarget; j++) {
            dp[0][j] = 0;
        }

        //code

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= derivedTarget; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][derivedTarget];

    }

    public static void main(String[] args) {

        Q7_TargetSum obj = new Q7_TargetSum();

        int[] arr1 = {1, 1, 1, 1, 1};
        int target1 = 3;

        int[] arr2 = {2, 1, 1, 2};
        int target2 = 2;

        int[] arr3 = {1, 2, 7, 9, 981};
        int target3 = 1000;

        System.out.println("Input: {1,1,1,1,1}, Target = 3 → Ways = "
                + obj.findTargetSumWays(arr1, target1));   // Output: 5

        System.out.println("Input: {2,1,1,2}, Target = 2 → Ways = "
                + obj.findTargetSumWays(arr2, target2));   // Output: 3

        System.out.println("Input: {1,2,7,9,981}, Target = 1000 → Ways = "
                + obj.findTargetSumWays(arr3, target3));  // Output: 1
    }
}
