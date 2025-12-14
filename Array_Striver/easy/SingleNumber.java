package Array_Striver.easy;

/**
 * @author manishkumar
 * <p>
 * <a href="https://leetcode.com/problems/single-number/">...</a>
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
