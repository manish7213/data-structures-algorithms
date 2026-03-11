package DP.Pattern_01_ZeroOneKnapsack;

import java.util.Arrays;

/**
 * @author manishkumar
 *
 * <a href="https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7">YouTube:subset-sum-problem</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1">GFG:subset-sum-problem</a>
 */
public class Q2_SubSetSum {

    static Boolean isSubsetSum(int[] arr, int sum) {
        // code here
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= sum; j++) { // Mind this initialization, if we make it from 0 it overwrites the true to false for (0,0).
            dp[0][j] = false;

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    static Boolean isSubsetSumRecursive(int arr[], int sum) {

        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];

        return subSetSumHelper(arr, sum, n, dp);

    }

    static Boolean subSetSumHelper(int[] arr, int sum, int n, Boolean[][] dp) {

        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        Boolean notTaken = subSetSumHelper(arr, sum, n - 1, dp);

        // This if-else condition can be removed by adding one more initial condition to check sum < 0 because we are handling that in this if-else.
        if (arr[n - 1] <= sum) {
            dp[n][sum] = subSetSumHelper(arr, sum - arr[n - 1], n - 1, dp) || subSetSumHelper(arr, sum, n - 1, dp);
        } else {
            dp[n][sum] = notTaken;
        }

        return dp[n][sum];
    }

    /**
     * More optimized
     */
    static Boolean isSubsetSumSpaceOptimized(int arr[], int sum) {

        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0 ; i < dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }


        return subSetSumHelper(arr, sum, n, dp);

    }

    /**
     * More optimized
     */
    static Boolean subSetSumHelper(int[] arr, int sum, int n, int[][] dp) {

        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum] != 0;
        }

        Boolean notTaken = subSetSumHelper(arr, sum, n - 1, dp);

        if (arr[n - 1] <= sum) {
            boolean taken = subSetSumHelper(arr, sum - arr[n - 1], n - 1, dp) || subSetSumHelper(arr, sum, n - 1, dp);
            if(taken) {
                dp[n][sum] = 1;
            } else {
                dp[n][sum] = 0;
            }
        } else {
            if(notTaken) {
                dp[n][sum] = 1;
            } else {
                dp[n][sum] = 0;
            }
        }

        return dp[n][sum] != 0;
    }

    public static void main(String[] args) {
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));    // true (4+5)
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 30));   // false (34-4)
        System.out.println(isSubsetSum(new int[]{1, 2, 3, 7}, 6));            // true (1+2+3)
        System.out.println(isSubsetSum(new int[]{1, 2, 7, 1, 5}, 10));        // true (1+2+7)
        System.out.println(isSubsetSum(new int[]{1, 2, 3}, 7));               // false
    }


}
