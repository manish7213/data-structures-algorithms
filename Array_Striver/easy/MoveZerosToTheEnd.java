package Array_Striver.easy;

/**
 * @author manishkumar
 * <a href="https://leetcode.com/problems/move-zeroes/">MoveZerosToTheEnd</a>
 */
public class MoveZerosToTheEnd {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }

        }
        while (nonZeroIndex < n) {
            nums[nonZeroIndex++] = 0;
        }
    }

}