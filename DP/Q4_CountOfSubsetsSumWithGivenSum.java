package DP;

/**
 * @author manishkumar
 * <p>
 * <a href="https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9">YouTube:Count Of Subsets Sum With Given Sum</a>
 * </p>
 * <p>
 * <a href="https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1">GFG: Count Of Subsets Sum With Given Sum</a>
 * </p>
 */
public class Q4_CountOfSubsetsSumWithGivenSum {

    public int perfectSum(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= target; j++) { // To be careful!
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) { // To be careful!
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        Q4_CountOfSubsetsSumWithGivenSum obj = new Q4_CountOfSubsetsSumWithGivenSum();

        int[] arr1 = {1, 2, 3, 3};
        int target1 = 6;

        int[] arr2 = {2, 3, 5, 6, 8, 10};
        int target2 = 10;

        System.out.println("Input: {1,2,3,3}, Target = 6 → Subset Count = "
                + obj.perfectSum(arr1, target1));    // Output: 3

        System.out.println("Input: {2,3,5,6,8,10}, Target = 10 → Subset Count = "
                + obj.perfectSum(arr2, target2));    // Output: 3
    }
}
