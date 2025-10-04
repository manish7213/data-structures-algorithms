package DP;

/**
 * <a href="https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9">...</a>
 *
 * <a href="https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1">...</a>
 */
public class CountOfSubsetsSumWithGivenSum_04 {

    public int perfectSum(int[] nums, int target) {

        int n = nums.length;
        int[][] mem = new int[n+1][target+1];

        for(int i = 0 ; i <= n ; i++){
            mem[i][0] = 1;
        }

        for(int j = 1 ; j <= target ; j++){ // Here j starts with 1 because
            mem[0][j] = 0;
        }

        for(int i = 1 ; i <= n; i++) {
            for(int j = 0 ; j <= target; j++) {
                if(nums[i-1] <= j) {
                    mem[i][j] = mem[i - 1][j - nums[i - 1]] + mem[i - 1][j];
                } else {
                    mem[i][j] = mem[i - 1][j];
                }
            }
        }
        return mem[n][target];
    }
}
