package DP;

import java.util.Arrays;
/**
 * @author manishkumar
 * <p>
 * <a href="https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13">YouTube: Count the number of subset with a given difference</a>
 * </p>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1">GFG: Count the number of subset with a given difference</a>
 * </p>
 */
public class CountOfSubsetWithGivenDifference_06 {
    int countPartitions(int[] nums, int d) {

        // code here
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if((d + sum) % 2 != 0) {
            return 0;
        }
        int target = (d + sum)/2;
        int[][] dp = new int[n+1][target+1];

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = 1;
        }

        for(int j = 1 ; j <= target ; j++){
            dp[0][j] = 0;
        }



        for(int i = 1 ; i <= n; i++) {
            for(int j = 0 ; j <= target; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
