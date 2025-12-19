package DP.Pattern_01_ZeroOneKnapsack;

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

    public static void main(String[] args) {
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));    // true (4+5)
        System.out.println(isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 30));   // false (34-4)
        System.out.println(isSubsetSum(new int[]{1, 2, 3, 7}, 6));            // true (1+2+3)
        System.out.println(isSubsetSum(new int[]{1, 2, 7, 1, 5}, 10));        // true (1+2+7)
        System.out.println(isSubsetSum(new int[]{1, 2, 3}, 7));               // false
    }


}
