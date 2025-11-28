package DP.Pattern_02_UnboundedKnapsack;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14">YouTube: Unbounded-knapsack</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1">GFG: Unbounded-knapsack</a>
 */
public class Q8_UnboundedKnapsack {

    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n + 1][capacity + 1];

        //Initialize
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }


        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = 0;
        }

        //Code
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[] val1 = {10, 40, 50, 70};
        int[] wt1  = {1,  3,  4,  5};
        int cap1   = 8;

        int[] val2 = {1, 30};
        int[] wt2  = {1, 50};
        int cap2   = 100;

        int[] val3 = {5, 11, 13};
        int[] wt3  = {2,  4,  6};
        int cap3   = 10;

        System.out.println("Test 1 → Max value = " + knapSack(val1, wt1, cap1)); // Expected: 110
        System.out.println("Test 2 → Max value = " + knapSack(val2, wt2, cap2)); // Expected: 100
        System.out.println("Test 3 → Max value = " + knapSack(val3, wt3, cap3)); // Expected: 27
    }
}
