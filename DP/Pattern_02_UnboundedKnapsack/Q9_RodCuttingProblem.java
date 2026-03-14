package DP.Pattern_02_UnboundedKnapsack;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author manishkumar
 * <br>
 * <a href="https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14">YouTube: Rod Cutting</a>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/rod-cutting0840/1">GFG: Rod Cutting</a>
 */
public class Q9_RodCuttingProblem {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;

        int[] len = IntStream.rangeClosed(1, n)
                .toArray();

        int[][] dp = new int[n + 1][n + 1];

        //initilize

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }

        //code
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][n];
    }

    public int cutRodHelper(int[] price) {
        int n = price.length;
        int[] wt = new int[n];
        for(int i = 0 ; i < n ;i++) {
            wt[i] = i+1;
        }
        int capacity = n;
        int[][] dp = new int[n + 1][capacity + 1];
        for(int i = 0 ; i < dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(price,wt,capacity,n,dp);
    }

    private int helper(int[] price, int[] wt, int capacity, int n, int[][] dp) {
        if(n == 0) {
            return 0;
        }

        if(capacity == 0) {
            return 0;
        }

        if(dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if(wt[n-1] <= capacity) {
            dp[n][capacity] = Math.max(price[n-1] + helper(price, wt, capacity - wt[n-1], n, dp),
                    helper(price, wt, capacity, n -1 , dp));
        } else {
            dp[n][capacity] = helper(price, wt, capacity, n -1 , dp);
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        Q9_RodCuttingProblem obj = new Q9_RodCuttingProblem();

        int[] p1 = {1, 5, 8, 9, 10, 17, 17, 20};
        int[] p2 = {3, 5, 8, 9, 10, 17, 17, 20};
        int[] p3 = {2, 5, 7, 8};

        System.out.println("Price: {1,5,8,9,10,17,17,20} → Max revenue = "
                + obj.cutRod(p1));  // Expected: 22

        System.out.println("Price: {3,5,8,9,10,17,17,20} → Max revenue = "
                + obj.cutRod(p2));  // Expected: 24

        System.out.println("Price: {2,5,7,8} → Max revenue = "
                + obj.cutRod(p3));  // Expected: 10
    }
}
