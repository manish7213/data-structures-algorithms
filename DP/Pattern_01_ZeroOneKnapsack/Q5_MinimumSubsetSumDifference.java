package DP.Pattern_01_ZeroOneKnapsack;

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

    public int minDifference(int[] arr) {
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

        for (int j = 0; j <= range / 2; j++) {
            if (dp[n][j]) { // last row of the dp matrix
                s1 = j;
            }
        }

        return range - 2 * s1;

    }

    public static void main(String[] args) {
        Q5_MinimumSubsetSumDifference obj = new Q5_MinimumSubsetSumDifference();

        int[] arr1 = {1, 6, 11, 5};
        int[] arr2 = {3, 1, 4, 2, 2};

        System.out.println("Input: {1, 6, 11, 5} → Min Difference = "
                + obj.minDifference(arr1));   // Output: 1

        System.out.println("Input: {3, 1, 4, 2, 2} → Min Difference = "
                + obj.minDifference(arr2));  // Output: 0
    }

}
