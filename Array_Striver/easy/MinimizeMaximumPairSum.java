package Array_Striver.easy;

import java.util.Arrays;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/">MinimizeMaximumPairSum</a>
 */
public class MinimizeMaximumPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            max = Math.max(max, nums[i] + nums[j]);
        }
        return max;
    }
}
