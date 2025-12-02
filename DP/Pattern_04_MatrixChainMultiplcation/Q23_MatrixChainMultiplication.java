package DP.Pattern_04_MatrixChainMultiplcation;

import java.util.Arrays;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34">YouTube: MatrixChainMultiplication</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1">GFG: MatrixChainMultiplication</a>
 * <p>
 * <p>
 */
public class Q23_MatrixChainMultiplication {

    static int matrixMultiplication(int[] arr) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return mcm_recursive(arr, 1, n - 1, dp);
    }

    private static int mcm_recursive(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int res = mcm_recursive(arr, i, k, dp) + mcm_recursive(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, res);
        }
        dp[i][j] = min;

        return dp[i][j];
    }

    public static void main(String[] args) {
        // ----- Predefined testcases -----
        int[][] testcases = {
                {40, 20, 30, 10, 30},
                {10, 20, 30, 40},
                {10, 30, 5, 60}
        };

        System.out.println("Matrix Chain Multiplication Results:");

        for (int[] arr : testcases) {
            int result = matrixMultiplication(arr);
            System.out.println(Arrays.toString(arr) + " -> " + result);
        }

    }
}
