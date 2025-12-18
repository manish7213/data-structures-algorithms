package Array_Striver.easy;

/**
 * @author manishkumar
 * <a href="https://leetcode.com/problems/maximum-subarray/description/">MaximumSubArrayKadensAlgo</a>
 */
public class MaximumSubArrayKadensAlgo {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum += n;

            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

}
