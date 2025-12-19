package Array_Striver.easy;

/**
 * @author manishkumar
 *
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/1859422421/">TwoSumProblem2</a>
 */
public class TwoSumProblem2 {

    // sorted input

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{i + 1, j + 1};
    }
}
